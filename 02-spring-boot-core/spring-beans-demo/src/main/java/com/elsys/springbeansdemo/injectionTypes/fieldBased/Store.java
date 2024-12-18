package com.elsys.springbeansdemo.injectionTypes.fieldBased;

import com.elsys.springbeansdemo.beanDefinition.xml.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Store {

    @Autowired
    private ItemsRepository itemsRepository;

    public List<Item> findAll() {
        return itemsRepository.findAll();
    }
}
