package com.nalmtal.WarehouseSpring;

public class Book implements Storable {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public void sendToWarehouse(Warehouse warehouse) {
        warehouse.addItem("Book: " + title);
    }
}
