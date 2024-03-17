package com.fiap.tc5apicarts.client;

import com.fiap.tc5apicarts.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "api-cart",
        url = "${app-config.services.cart}"
)
public interface CartFeignClient{

    @GetMapping("/stock/{uuid}")
    ResponseEntity<ProductDTO> findByUuid(@PathVariable UUID uuid);
}
