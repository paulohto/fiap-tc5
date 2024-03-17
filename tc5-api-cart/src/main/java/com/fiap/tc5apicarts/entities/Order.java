package com.fiap.tc5apicarts.entities;

import com.fiap.tc5apicarts.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_order;

    private Long id_client;
    private UUID uuid_product;
    private Instant moment;
    private OrderStatus status;

    private List<ProductDTO> products = new ArrayList<>();


    public Order(UUID id_order, Instant moment, OrderStatus status) {
        this.id_order = id_order;
        this.moment = moment;
        this.status = status;
    }
}
