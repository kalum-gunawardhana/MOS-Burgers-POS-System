package edu.pos.controller;

import edu.pos.dto.Item;
import edu.pos.service.ItemService;
import edu.pos.util.CategoryType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
@CrossOrigin
public class ItemController {
    final ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getItems(){
        List<Item> items = itemService.getItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/add")
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Integer id){
        Item item = itemService.getItem(id);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/update/{id}")
    public void updateItem(@PathVariable Integer id, @RequestBody Item item) {
        itemService.updateItem(id, item);
    }

    @DeleteMapping("delete/{id}")
    public void deleteItem(@PathVariable Integer id){
        itemService.deleteItem(id);
    }

    @GetMapping("/getCategory/{category}")
    public ResponseEntity<List<Item>> getItemByCategory(@PathVariable CategoryType category){
        List<Item> itemByCategory = itemService.getItemByCategory(category);
        return ResponseEntity.ok(itemByCategory);
    }

    @GetMapping("/getItem/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Integer id){
        Item itemById = itemService.getItemById(id);
        return ResponseEntity.ok(itemById);
    }
}