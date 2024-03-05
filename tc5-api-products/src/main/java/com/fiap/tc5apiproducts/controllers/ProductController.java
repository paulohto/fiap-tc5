package com.fiap.tc5apiproducts.controllers;

import com.fiap.tc5apiproducts.dto.ProductDTO;
import com.fiap.tc5apiproducts.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO> listProducts = productService.findAll();
        return ResponseEntity.ok().body(listProducts);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID uuid){

        ProductDTO dto = productService.findById(uuid);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){

        dto = productService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId_product()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{uuid}")
    public ResponseEntity<ProductDTO> update(@PathVariable UUID uuid, @RequestBody ProductDTO dto){

        dto = productService.update(uuid, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<Void> update(@PathVariable UUID uuid){

        productService.delete(uuid);
        return ResponseEntity.noContent().build();
    }
}
