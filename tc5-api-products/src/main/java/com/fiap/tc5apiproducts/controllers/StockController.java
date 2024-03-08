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

    @PostMapping(value = "/{uuid}/input")
    public ResponseEntity<StockDTO> input(@PathVariable UUID uuid, @RequestBody StockInputDTO dto){

        StockDTO stockDTO = stockService.insertInput(uuid, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(uuid).toUri();
        return ResponseEntity.created(uri).body(stockDTO);
    }

    @PostMapping(value = "/{uuid}/output")
    public ResponseEntity<StockDTO> output(@PathVariable UUID uuid, @RequestBody StockOutputDTO dto){

        StockDTO stockDTO = stockService.insertOutput(uuid, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(uuid).toUri();
        return ResponseEntity.created(uri).body(stockDTO);
    }
}
