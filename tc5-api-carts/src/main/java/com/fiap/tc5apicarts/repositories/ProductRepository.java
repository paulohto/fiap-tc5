package com.fiap.tc5apicarts.repositories;

import com.fiap.tc5apicarts.entities.Order;
import com.fiap.tc5apicarts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
