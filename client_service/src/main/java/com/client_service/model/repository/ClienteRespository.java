package com.client_service.model.repository;

import com.client_service.model.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRespository extends CrudRepository<Cliente, Integer> {
}
