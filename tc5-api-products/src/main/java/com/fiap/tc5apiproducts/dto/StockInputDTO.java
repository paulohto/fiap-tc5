package com.fiap.tc5apiproducts.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Jacksonized
@Builder
@Data
public class StockInputDTO {

    private UUID id_product;
    private Integer amount_stock;

    public StockInputDTO() {
    }

    public StockInputDTO(UUID id_product, Integer stock) {
        this.id_product = id_product;
        this.amount_stock = stock;
    }
}
