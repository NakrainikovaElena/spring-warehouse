package com.nalmtal.WarehouseSpring;

public class Food implements Storable {

    private String name;

    public Food(String name) {
        this.name = name;
    }

    @Override
    public void sendToWarehouse(Warehouse warehouse) {
        warehouse.addItem("Food: " + name);
    }
}