package com.fiap.tc5apiproducts.controllers;

import com.fiap.tc5apiproducts.dto.StockDTO;
import com.fiap.tc5apiproducts.dto.StockInputDTO;
import com.fiap.tc5apiproducts.dto.StockOutputDTO;
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

    @PostMapping(value = "/input")
    public ResponseEntity<StockDTO> input(@RequestBody StockInputDTO dto){

        StockDTO stockDTO = stockService.insertInput(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dto.getId_product()).toUri();
        return ResponseEntity.created(uri).body(stockDTO);
    }

    @PostMapping(value = "/output")
    public ResponseEntity<StockDTO> output(@RequestBody StockOutputDTO dto){

        StockDTO stockDTO = stockService.insertOutput(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dto.getId_product()).toUri();
        return ResponseEntity.created(uri).body(stockDTO);
    }
}
