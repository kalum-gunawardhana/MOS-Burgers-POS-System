package edu.pos.dto;

import edu.pos.util.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Integer id;
    private String itemName;
    private Double price;
    private Double discount;
    private CategoryType category;
}