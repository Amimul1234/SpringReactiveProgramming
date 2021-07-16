package com.rahi.springreactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Amimul Ehsan
 * @version 1.0
 * @date 7/16/2021 9:27 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {
    @Id
    private String id;
    private String name;
    private int qty;
    private double price;
}
