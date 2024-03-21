package com.fiap.tc5apipayments.entities;

import com.fiap.tc5apipayments.entities.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private UUID id_order;

    private Instant moment;
    private OrderStatus status;

    private Set<Product> products = new HashSet<>();


    public Order(UUID id_order, Instant moment, OrderStatus status) {
        this.id_order = id_order;
        this.moment = moment;
        this.status = status;
    }
}
