package com.fiap.tc5apicarts.services;


import com.fiap.tc5apicarts.client.ProductFeignClient;
import com.fiap.tc5apicarts.dto.OrderDTO;
import com.fiap.tc5apicarts.dto.ProductDTO;
import com.fiap.tc5apicarts.entities.Order;
import com.fiap.tc5apicarts.entities.Product;
import com.fiap.tc5apicarts.entities.enums.OrderStatus;
import com.fiap.tc5apicarts.exceptions.ResourceNotFoundException;
import com.fiap.tc5apicarts.repositories.OrderRepository;
import com.fiap.tc5apicarts.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
    private ProductRepository productRepository;

    @Autowired
    private ProductFeignClient productFeignClient;

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
        Order order = new Order(null,
                Instant.now(), OrderStatus.PENDING);
        for (ProductDTO p : dto.getProducts()){
            ProductDTO product = productFeignClient.findByUuid(p.getId_product());
            order.getProducts().add(copyDtoToEntity(product));
            productRepository.save(copyDtoToEntity(product));
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

    private Product copyDtoToEntity(ProductDTO dto){
        var product = new Product();
        product.setId_product(dto.getId_product());
        product.setPrice(dto.getPrice());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setImageuri(dto.getImageUri());
        return product;
    }
}
