package com.fiap.tc5apicarts.dto;


import com.fiap.tc5apicarts.entities.Cart;
import com.fiap.tc5apicarts.entities.Product;
import com.fiap.tc5apicarts.entities.enums.CartStatus;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Jacksonized
@Builder
@Data
public class CartDTO {

    private Instant moment;
    private CartStatus status;
    private Set<ProductDTO> products = new HashSet<>();
    private Double total = 0.00;


    public CartDTO() {
    }
    public CartDTO(Instant moment, CartStatus status) {
        this.moment = moment;
        this.status = status;
    }
    public CartDTO(Cart entity) {
        products = entity.getProducts();
        total = entity.getTotal();
    }
}
