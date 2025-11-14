package com.nalmtal.WarehouseSpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    private final Warehouse warehouse;

    public Main(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run(String... args) {
        Storable book = new Book("War and Peace");
        Storable tool = new Tool("Hammer");
        Storable food = new Food("Apple");

        // Отправляем на склад
        book.sendToWarehouse(warehouse);
        tool.sendToWarehouse(warehouse);
        food.sendToWarehouse(warehouse);

        System.out.println("\n--- We receive items from the warehouse ---");
        warehouse.getItem("Book: War and Peace");

        try {
            warehouse.getItem("Telephone"); // вызовет исключение
        } catch (Exception e) {
            System.out.println("Processing error: " + e.getMessage());
        }
    }
}
