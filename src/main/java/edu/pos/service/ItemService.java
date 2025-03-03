package edu.pos.service;

import edu.pos.dto.Item;
import edu.pos.util.CategoryType;
import java.util.List;

public interface ItemService {
    List<Item> getItems();
    void addItem(Item item);
    Item getItem(Integer id);
    void updateItem(Integer id, Item item);
    void deleteItem(Integer id);
    List<Item> getItemByCategory(CategoryType category);
    Item getItemById(Integer itemCode);
}