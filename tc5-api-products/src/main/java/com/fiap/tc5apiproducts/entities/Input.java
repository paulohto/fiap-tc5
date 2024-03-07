package com.fiap.tc5apiproducts.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_input")
public class Input {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_input;

    @ManyToOne
    private Product product;

    private Double price;
    private Integer amount;
    private Timestamp date_input;
}
