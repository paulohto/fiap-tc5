package com.fiap.tc5apipayments.services;

import com.fiap.tc5apipayments.client.OrderFeignClient;
import com.fiap.tc5apipayments.dto.OrderDTO;
import com.fiap.tc5apipayments.entities.enums.OrderStatus;
import com.fiap.tc5apipayments.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private OrderFeignClient orderFeignClient;

    public OrderDTO setPaid(UUID uuid){
        try {
            return orderFeignClient.orderPaid(uuid);
        }
        catch (RuntimeException e){
            throw new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid);
        }
    }
}
