package com.fiap.tc5apicarts.dto;


import com.fiap.tc5apicarts.entities.Cart;
import com.fiap.tc5apicarts.entities.enums.CartStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
public class CartDTO {

    private Instant moment;
    private CartStatus status;
    private Set<ProductDTO> products = new HashSet<>();
    private BigDecimal total;

    public CartDTO(Instant moment, CartStatus status) {
        this.moment = moment;
        this.status = status;
    }
    public CartDTO(Cart entity) {
        products = entity.getProducts();
        total = entity.getTotal();
    }
    public BigDecimal getTotal(){
        return products.stream().map(ProductDTO::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
