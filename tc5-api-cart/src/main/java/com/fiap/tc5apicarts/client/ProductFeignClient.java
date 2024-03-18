package com.fiap.tc5apicarts.client;

import com.fiap.tc5apicarts.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "api-product",
        url = "${app-config.services.product}"
)
public interface ProductFeignClient {

    @GetMapping("/stock/{uuid}")
    ResponseEntity<ProductDTO> findByUuid(@PathVariable UUID uuid);
}
