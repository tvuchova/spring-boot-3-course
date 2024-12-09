package com.elsys.springbeansdemo.service.fieldBased;

import com.elsys.springbeansdemo.service.xml.Item;
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
