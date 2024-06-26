package com.fiap.tc5apicarts.services;


import com.fiap.tc5apicarts.client.ProductFeignClient;
import com.fiap.tc5apicarts.dto.CartDTO;
import com.fiap.tc5apicarts.dto.ProductDTO;
import com.fiap.tc5apicarts.entities.enums.CartStatus;
import com.fiap.tc5apicarts.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
public class CartService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Transactional
    public CartDTO insert(UUID uuid, Integer amount) {
        CartDTO cart = new CartDTO(Instant.now(), CartStatus.PENDING);
        ProductDTO product = productFeignClient.findByUuid(uuid);
        product.setAmount(amount);
        cart.getProducts().add(product);
        cart.setTotal(product.getTotal());
        return cart;
    }
}
