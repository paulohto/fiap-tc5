package com.fiap.tc5apiproducts.dto;

import com.fiap.tc5apiproducts.entities.Product;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Jacksonized
@Builder
@Data
public class StockDTO {

    private UUID id_product;
    private String name;
    private Double price;
    private String description;
    private String imageUri;
    private Integer amount_stock;

    private List<InputDTO> inputs = new ArrayList<>();
    private List<OutputDTO> outputs = new ArrayList<>();

    public StockDTO() {
    }
    public StockDTO(UUID id_product, String name, Double price, String description, String imageUri)
    {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
    }

    public StockDTO(Product entity) {
        id_product = entity.getId_product();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUri = entity.getImageuri();
        inputs = entity.getInputs().stream().map(InputDTO::new).collect(Collectors.toList());
        outputs = entity.getOutputs().stream().map(OutputDTO::new).collect(Collectors.toList());
    }
}
