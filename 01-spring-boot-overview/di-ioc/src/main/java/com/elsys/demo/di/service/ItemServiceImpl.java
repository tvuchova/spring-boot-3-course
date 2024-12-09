package com.elsys.demo.di.service;

import com.elsys.demo.di.model.Item;
import com.elsys.demo.di.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(@Qualifier("inMemoryItemRepository") ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
