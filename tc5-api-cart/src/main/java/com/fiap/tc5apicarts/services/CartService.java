package com.fiap.tc5apicarts.services;


import com.fiap.tc5apicarts.client.CartFeignClient;
import com.fiap.tc5apicarts.dto.OrderDTO;
import com.fiap.tc5apicarts.dto.ProductDTO;
import com.fiap.tc5apicarts.entities.Order;
import com.fiap.tc5apicarts.entities.OrderStatus;
import com.fiap.tc5apicarts.entities.Product;
import com.fiap.tc5apicarts.exceptions.ResourceNotFoundException;
import com.fiap.tc5apicarts.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartFeignClient cartFeignClient;

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order(null,
                Instant.now(), OrderStatus.PENDING);
        for (ProductDTO p : dto.getProducts()){
            ProductDTO product = cartFeignClient.findByUuid(p.getId_product()).getBody();
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }
}
