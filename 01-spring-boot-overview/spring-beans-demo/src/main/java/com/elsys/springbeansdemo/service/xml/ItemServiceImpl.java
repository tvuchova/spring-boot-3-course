package com.elsys.springbeansdemo.service.xml;

import com.elsys.springbeansdemo.service.xml.repository.ItemRepository;

import java.util.List;


public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
