package com.fiap.tc5apicarts.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Product {

    private UUID id_product;

    private String name;
    private Double price;
    private String description;
    private Integer amount;
}
