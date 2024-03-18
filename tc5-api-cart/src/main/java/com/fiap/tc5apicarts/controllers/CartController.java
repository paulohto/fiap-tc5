package com.fiap.tc5apicarts.controllers;

import com.fiap.tc5apicarts.dto.CartDTO;
import com.fiap.tc5apicarts.dto.OrderDTO;
import com.fiap.tc5apicarts.services.CartService;
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
    private CartService cartService;

    @PostMapping("/product/{uuid}")
    public ResponseEntity<CartDTO> insert(@PathVariable UUID uuid) {
        return ResponseEntity.ok(cartService.insert(uuid));
    }
}
