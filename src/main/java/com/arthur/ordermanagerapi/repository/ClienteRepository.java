package com.arthur.ordermanagerapi.repository;

import com.arthur.ordermanagerapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c where c.active = true")
    List<Cliente> findAllByActive();
}
