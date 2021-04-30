package com.acorn.cafe.Ingredient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {
    private int id;
    private String name;
    private int quantity;
    private int price;
    private String unit;
    private String partner;

}
