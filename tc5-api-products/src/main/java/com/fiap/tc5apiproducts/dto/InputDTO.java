package com.fiap.tc5apiproducts.dto;

import com.fiap.tc5apiproducts.entities.Input;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.sql.Timestamp;
import java.util.UUID;

@Jacksonized
@Builder
@Data
public class InputDTO {

    private UUID id_input;
    private Double price;
    private Integer amount;
    private Timestamp date_input;

    public InputDTO() {
    }

    public InputDTO(UUID id_input, Double price, Integer amount) {
        this.id_input = id_input;
        this.price = price;
        this.amount = amount;
    }

    public InputDTO(Input entity) {
        id_input = entity.getId_input();
        price = entity.getPrice();
        amount = entity.getAmount();
        date_input = entity.getDate_input();
    }
}
