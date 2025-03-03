package edu.pos.service.impl;

import edu.pos.dto.Item;
import edu.pos.entity.ItemEntity;
import edu.pos.repository.ItemDao;
import edu.pos.service.ItemService;
import edu.pos.util.CategoryType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    final ItemDao itemDao;
    final ModelMapper modelMapper;

    @Override
    public List<Item> getItems() {
        List<ItemEntity> all = itemDao.findAll();
        List<Item> objectArrayList = new ArrayList<>();
        all.forEach(itemEntity -> objectArrayList.add(modelMapper.map(itemEntity, Item.class)));
        return objectArrayList;
    }

    @Override
    public void addItem(Item item) {
        itemDao.save(modelMapper.map(item, ItemEntity.class));
    }

    @Override
    public Item getItem(Integer id) {
        Optional<ItemEntity> byId = itemDao.findById(id);
        return modelMapper.map(byId, Item.class);
    }

    @Override
    public void updateItem(Integer id, Item item) {
        Optional<ItemEntity> optionalItem = itemDao.findById(id);

        if (optionalItem.isPresent()) {
            ItemEntity existingItem = optionalItem.get();
            existingItem.setItemName(item.getItemName());
            existingItem.setPrice(item.getPrice());
            existingItem.setDiscount(item.getDiscount());
            existingItem.setCategory(item.getCategory());

            itemDao.save(existingItem);
        }
    }

    @Override
    public void deleteItem(Integer id) {
        itemDao.deleteById(id);
    }

    @Override
    public List<Item> getItemByCategory(CategoryType category) {
        List<ItemEntity> allByCategory = itemDao.findAllByCategory(category);

        return allByCategory.stream()
                .map(itemEntity -> modelMapper.map(itemEntity, Item.class))
                .collect(Collectors.toList());
    }

    @Override
    public Item getItemById(Integer id) {
        Optional<ItemEntity> byId = itemDao.findById(id);
        return modelMapper.map(byId, Item.class);
    }
}