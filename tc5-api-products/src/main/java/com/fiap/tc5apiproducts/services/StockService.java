package com.fiap.tc5apiproducts.services;

import com.fiap.tc5apiproducts.dto.*;
import com.fiap.tc5apiproducts.entities.Input;
import com.fiap.tc5apiproducts.entities.Output;
import com.fiap.tc5apiproducts.entities.Product;
import com.fiap.tc5apiproducts.exceptions.ResourceNotFoundException;
import com.fiap.tc5apiproducts.repositories.InputRepository;
import com.fiap.tc5apiproducts.repositories.OutputRepository;
import com.fiap.tc5apiproducts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StockService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InputRepository inputRepository;
    @Autowired
    private OutputRepository outputRepository;

    @Transactional(readOnly = true)
    public StockDTO findById(UUID uuid){
        Optional<Product> obj = productRepository.findById(uuid);
        Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid));
        return new StockDTO(product);
    }
    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        List<Product> listStock = productRepository.findAllByOrderByNameAsc();
        return listStock.stream().map(StockDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public Page<StockDTO> findAllPaged(Pageable pageable){
        Page<Product> list = productRepository.findAll(pageable);
        return list.map(StockDTO::new);
    }
    @Transactional
    public StockDTO insertInput(UUID uuid, StockInputDTO dto){
        Optional<Product> obj = productRepository.findById(uuid);
        Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid));
        Input input = inputStock(product, dto);
        product = productRepository.save(product);
        inputRepository.save(input);

        return copyEntityToStockDto(product);
    }
    @Transactional
    public StockDTO insertOutput(UUID uuid, StockOutputDTO dto){
        Optional<Product> obj = productRepository.findById(uuid);
        Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid));
        Output output = outputStock(product, dto);
        product = productRepository.save(product);
        outputRepository.save(output);

        return copyEntityToStockDto(product);
    }
//    @Transactional
//    public ProductDTO insert(ProductDTO dto){
//        Product product = new Product();
//        copyDtoToEntity(dto, product);
//        product = productRepository.save(product);
//        return new ProductDTO(product);
//    }
//    @Transactional
//    public ProductDTO update(UUID uuid, StockInputDTO dto){
//        Optional<Product> obj = productRepository.findById(uuid);
//        Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid));
//        outputStock(product);
//        return new ProductDTO(product);
//    }
    private Input inputStock(Product product, StockInputDTO inputDTO){
        Input input = new Input();
        input.setDate_input(Timestamp.from(Instant.now()));
        input.setAmount(inputDTO.getAmount_stock());
        input.setPrice(product.getPrice());
        input.setProduct(product);
        product.addInput(input);
        return input;
    }
    private Output outputStock(Product product, StockOutputDTO outputDTO){
        Output output = new Output();
        output.setDate_output(Timestamp.from(Instant.now()));
        output.setAmount(outputDTO.getAmount_stock());
        output.setPrice(product.getPrice());
        output.setProduct(product);
        product.addOut(output);
        return output;
    }
    private StockDTO copyEntityToStockDto(Product product){
        StockDTO stockDTO = new StockDTO();

        stockDTO.setId_product(product.getId_product());
        stockDTO.setName(product.getName());
        stockDTO.setPrice(product.getPrice());
        stockDTO.setDescription(product.getDescription());
        stockDTO.setImageUri(product.getImageuri());
        stockDTO.setInputs(product.getInputs().stream().map(InputDTO::new).collect(Collectors.toList()));
        stockDTO.setOutputs(product.getOutputs().stream().map(OutputDTO::new).collect(Collectors.toList()));

        return stockDTO;
    }
}
