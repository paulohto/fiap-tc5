package com.fiap.tc5apipayments.client;


import com.fiap.tc5apipayments.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@FeignClient(
        name = "api-order",
        url = "http://localhost:8082"
)
public interface OrderFeignClient {

    @GetMapping("/orders/{uuid}")
    OrderDTO orderByUuid(@PathVariable UUID uuid);

    @PutMapping("/orders/{uuid}/paid")
    OrderDTO orderPaid(@PathVariable UUID uuid);
}
