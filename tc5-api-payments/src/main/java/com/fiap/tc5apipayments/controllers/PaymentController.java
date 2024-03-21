package com.fiap.tc5apipayments.controllers;

import com.fiap.tc5apipayments.dto.OrderDTO;
import com.fiap.tc5apipayments.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PutMapping(value = "/{uuid}/paid")
    public ResponseEntity<OrderDTO> setPaid(@PathVariable UUID uuid){

        OrderDTO dto = paymentService.setPaid(uuid);
        return ResponseEntity.ok().body(dto);
    }
}
