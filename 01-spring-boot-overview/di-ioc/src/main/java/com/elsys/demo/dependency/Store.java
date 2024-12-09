package com.elsys.demo.dependency;

import java.util.List;

public class Store {
    private List<Item> items;

    public Store() {
        items = List.of(
                new Item("Book", "A novel", 10.99),
                new Item("Pen", "A blue pen", 1.49)
        );
    }
}
