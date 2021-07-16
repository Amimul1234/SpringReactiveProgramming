package com.rahi.springreactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Amimul Ehsan
 * @version 1.0
 * @date 7/16/2021 9:24 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private int qty;
    private double price;
}
