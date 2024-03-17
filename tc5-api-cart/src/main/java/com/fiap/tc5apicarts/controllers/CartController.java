package com.fiap.tc5apicarts.controllers;

import com.fiap.tc5apicarts.dto.OrderDTO;
import com.fiap.tc5apicarts.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/carts")
public class CartController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto) {
        dto = orderService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}")
                .buildAndExpand(dto.getId_order()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
