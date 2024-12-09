package com.elsys.springbeansdemo.service.xml.repository;

import com.elsys.springbeansdemo.service.xml.Item;

import java.util.List;

public interface ItemRepository {
    public List<Item> findAll();
}
