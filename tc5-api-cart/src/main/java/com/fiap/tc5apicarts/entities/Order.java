package com.fiap.tc5apicarts.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_order;

    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;

    @ManyToMany
    @JoinTable(name = "tb_order_product",
    joinColumns = @JoinColumn(name = "id_order"),
    inverseJoinColumns = @JoinColumn(name = "id_product"))
    private Set<Product> products = new HashSet<>();

    public Order(UUID id_order, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
        this.id_order = id_order;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
    }
}
