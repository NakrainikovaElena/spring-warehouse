package com.nalmtal.WarehouseSpring;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Warehouse {

    private final List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " placed in a warehouse.");
    }

    public String getItem(String name) {
        if (!items.contains(name)) {
            throw new RuntimeException("Item " + name + " out of warehouse!");
        }
        items.remove(name);
        return name;
    }

    public List<String> getAllItems() {
        return items;
    }
}
