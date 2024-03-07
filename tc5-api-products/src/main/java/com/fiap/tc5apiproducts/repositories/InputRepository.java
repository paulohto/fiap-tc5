package com.fiap.tc5apiproducts.repositories;

import com.fiap.tc5apiproducts.entities.Input;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InputRepository extends JpaRepository<Input, UUID> {

}
