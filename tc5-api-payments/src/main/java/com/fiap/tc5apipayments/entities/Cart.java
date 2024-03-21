package com.fiap.tc5apipayments.entities;

import com.fiap.tc5apipayments.dto.ProductDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
public class Cart {

    private Integer amount;
    private BigDecimal total;

    private Set<ProductDTO> products = new HashSet<>();
}
