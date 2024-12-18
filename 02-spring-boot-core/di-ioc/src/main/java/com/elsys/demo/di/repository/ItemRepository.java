package com.elsys.demo.di.repository;

import com.elsys.demo.di.model.Item;

import java.util.List;

public interface ItemRepository {
    public List<Item> findAll();
}
