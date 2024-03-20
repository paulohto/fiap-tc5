package com.fiap.tc5apicarts.entities;

import com.fiap.tc5apicarts.dto.ProductDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class Cart {

    private Integer amount;
    private BigDecimal total;

    private Set<ProductDTO> products = new HashSet<>();
}
