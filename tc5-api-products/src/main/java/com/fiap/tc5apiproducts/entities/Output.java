package com.fiap.tc5apiproducts.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_output")
public class Output {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_output;

    @ManyToOne
    private Product product;

    private Double price;
    private Integer amount;
    private Timestamp date_output;
}
