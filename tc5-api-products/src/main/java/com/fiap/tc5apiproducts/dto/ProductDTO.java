package com.fiap.tc5apiproducts.dto;

import com.fiap.tc5apiproducts.entities.Product;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Jacksonized
@Builder
@Data
public class ProductDTO {

    private UUID id_product;
    private String name;
    private Double price;
    private String description;
    private String imageUri;
    private Integer amount;

    public ProductDTO() {
    }

    public ProductDTO(UUID id_product, String name, Double price, String description, String imageUri, Integer amount) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
        this.amount = amount;
    }

    public ProductDTO(Product entity) {
        id_product = entity.getId_product();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUri = entity.getImageuri();
        amount = entity.getAmount();
    }
}
