package com.fiap.tc5apicarts.entities;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Cart {

    private Integer amount;
    private Double total;
    private Set<Product> products = new HashSet<>();
}
