package com.nalmtal.WarehouseSpring;

public class Tool implements Storable {
    private String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public void sendToWarehouse(Warehouse warehouse) {
        warehouse.addItem("Tool: " + name);
    }
}
