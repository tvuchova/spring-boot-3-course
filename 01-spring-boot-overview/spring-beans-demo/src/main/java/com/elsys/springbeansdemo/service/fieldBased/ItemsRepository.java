package com.elsys.springbeansdemo.service.fieldBased;

import com.elsys.springbeansdemo.service.xml.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemsRepository {
    public List<Item> findAll() {
        return List.of(new Item("item1","dd",2), new Item("item2","dd",2));
    }
}
