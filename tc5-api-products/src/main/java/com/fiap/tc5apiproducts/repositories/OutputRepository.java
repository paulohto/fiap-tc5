package com.fiap.tc5apiproducts.repositories;

import com.fiap.tc5apiproducts.entities.Output;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OutputRepository extends JpaRepository<Output, UUID> {

}
