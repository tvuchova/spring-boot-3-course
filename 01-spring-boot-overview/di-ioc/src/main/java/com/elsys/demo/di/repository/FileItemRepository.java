package com.elsys.demo.di.repository;

import com.elsys.demo.di.model.Item;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Repository("fileItem")
public class FileItemRepository implements ItemRepository {
    @Override
    public List<Item> findAll() {
        return new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("items.csv")))
                .lines()
                .map(this::asItem)
                .toList();
    }

    private Item asItem(String item) {
        try {
            String[] parts = item.split(",");
            String name = parts[0].trim();
            String description = parts[1].trim();
            double price = Double.parseDouble(parts[2].trim());
            return new Item(name, description, price);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid line: " + item, e);
        }
    }
}
