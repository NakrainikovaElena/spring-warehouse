package com.nalmtal.WarehouseSpring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WarehouseAspect {

    @Before("execution(* Warehouse.getItem(..))")
    public void beforeGettingItem(JoinPoint jp) {
        System.out.println("[Before] Trying to get an item: " + jp.getArgs()[0]);
    }

    @AfterReturning(pointcut = "execution(* Warehouse.getItem(..))", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        System.out.println("[AfterReturning] Item received successfully: " + result);
    }

    @AfterThrowing(pointcut = "execution(* Warehouse.getItem(..))", throwing = "ex")
    public void afterThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("[AfterThrowing] Error when receiving the item: " + ex.getMessage());
    }

    @After("execution(* Warehouse.getItem(..))")
    public void afterFinally(JoinPoint jp) {
        System.out.println("[After] The getItem method has completed execution (success or error).");
    }

    @Around("execution(* Warehouse.addItem(..))")
    public Object aroundAdd(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[Around] Before adding an item: " + pjp.getArgs()[0]);
        Object result = pjp.proceed(); // выполняем основной метод
        System.out.println("[Around] After adding an item: " + pjp.getArgs()[0]);
        return result;
    }
}