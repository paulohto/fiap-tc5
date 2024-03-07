package com.fiap.tc5apiproducts.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_product;

    private String name;
    private Double price;
    private String description;
    private String imageuri;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Output> outputs= new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Input> inputs= new ArrayList<>();

    public void addInput(Input input){
        this.inputs.add(input);
    }
    public void addOut(Output output){
        this.outputs.add(output);
    }
}
