package com.fiap.tc5apicarts.entities;

import com.fiap.tc5apicarts.dto.ProductDTO;
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

    private Set<ProductDTO> products = new HashSet<>();
}
