package com.fiap.tc5apipayments.entities;


import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Product {

    private UUID id_product;

    private String name;
    private BigDecimal price;
    private String description;
    private String imageuri;
}
