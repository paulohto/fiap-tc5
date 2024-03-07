package com.fiap.tc5apiproducts.controllers;

import com.fiap.tc5apiproducts.dto.ProductDTO;
import com.fiap.tc5apiproducts.dto.StockDTO;
import com.fiap.tc5apiproducts.dto.StockInputDTO;
import com.fiap.tc5apiproducts.services.ProductService;
import com.fiap.tc5apiproducts.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<StockDTO>> findAll(){
        List<StockDTO> listStock = stockService.findAll();
        return ResponseEntity.ok().body(listStock);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<StockDTO> findById(@PathVariable UUID uuid){

        StockDTO dto = stockService.findById(uuid);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "/{uuid}/input")
    public ResponseEntity<StockDTO> insert(@PathVariable UUID uuid, @RequestBody StockInputDTO dto){

        StockDTO stockDTO = stockService.insert(uuid, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(uuid).toUri();
        return ResponseEntity.created(uri).body(stockDTO);
    }

    @PostMapping(value = "/{uuid}/output")
    public ResponseEntity<ProductDTO> insert(@PathVariable UUID uuid, @RequestBody ProductDTO dto){

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
