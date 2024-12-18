package com.elsys.springbeansdemo.beanDefinition.xml;

import com.elsys.springbeansdemo.beanDefinition.xml.repository.ItemRepository;

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
