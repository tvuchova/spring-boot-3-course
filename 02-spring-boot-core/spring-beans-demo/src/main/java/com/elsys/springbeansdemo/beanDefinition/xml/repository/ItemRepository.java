package com.elsys.springbeansdemo.beanDefinition.xml.repository;

import com.elsys.springbeansdemo.beanDefinition.xml.Item;

import java.util.List;

public interface ItemRepository {
    public List<Item> findAll();
}
