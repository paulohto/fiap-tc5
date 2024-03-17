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
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartFeignClient cartFeignClient;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> listOrders = orderRepository.findOrdersWithProducts();
        return listOrders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public OrderDTO findById(UUID uuid){
        Optional<Order> obj = orderRepository.findById(uuid);
        Order order = obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid));
        return new OrderDTO(order);
    }
    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for (ProductDTO p : dto.getProducts()){
            Product product = productRepository.getReferenceById(p.getId_product());
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }
    @Transactional
    public OrderDTO setPaid(UUID uuid){
        try {
            Order order = orderRepository.getReferenceById(uuid);
            order.setStatus(OrderStatus.PAID);
            order = orderRepository.save(order);
            return new OrderDTO(order);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid);
        }
    }
}
