package com.aster.ecom.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    @Min(value=1, message= "{sku.invalid}")
    private String sku;
    private String name;
    private String description;
    private int quantity;
    private String imageUrl;
    @Min(value=1, message= "{quantity.invalid}")
    private double price;

}
