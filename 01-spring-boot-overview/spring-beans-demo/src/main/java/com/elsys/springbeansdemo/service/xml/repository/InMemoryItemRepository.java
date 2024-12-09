package com.elsys.springbeansdemo.service.xml.repository;

import com.elsys.springbeansdemo.service.xml.Item;

import java.util.List;


public class InMemoryItemRepository implements ItemRepository {
    @Override
    public List<Item> findAll() {
        return List.of(
                new Item("Item1", "Description1", 10.0),
                new Item("Item2", "Description2", 20.0),
                new Item("Item3", "Description3", 30.0)
        );
    }
}
