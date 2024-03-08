package com.fiap.tc5apiproducts.dto;

import com.fiap.tc5apiproducts.entities.Output;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class OutputDTO {

    private UUID id_output;
    private Double price;
    private Integer amount;
    private Timestamp date_output;

    public OutputDTO() {
    }

    public OutputDTO(UUID id_output, Double price, Integer amount) {
        this.id_output = id_output;
        this.price = price;
        this.amount = amount;
    }

    public OutputDTO(Output entity) {
        id_output = entity.getId_output();
        price = entity.getPrice();
        amount = entity.getAmount();
        date_output = entity.getDate_output();
    }
}
