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
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        List<OrderDTO> listOrders = orderService.findAll();
        return ResponseEntity.ok().body(listOrders);
    }
    @GetMapping(value = "/{uuid}")
    public ResponseEntity<OrderDTO> findById(@PathVariable UUID uuid){

        OrderDTO dto = orderService.findById(uuid);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto) {
        dto = orderService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}")
                .buildAndExpand(dto.getId_order()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{uuid}/delivered")
    public ResponseEntity<OrderDTO> setDelivered(@PathVariable UUID uuid){

        OrderDTO dto = orderService.setDelivered(uuid);
        return ResponseEntity.ok().body(dto);
    }
    @PutMapping(value = "/{uuid}/paid")
    public ResponseEntity<OrderDTO> setPaid(@PathVariable UUID uuid){

        OrderDTO dto = orderService.setPaid(uuid);
        return ResponseEntity.ok().body(dto);
    }
}
