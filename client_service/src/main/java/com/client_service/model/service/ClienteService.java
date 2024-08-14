package com.client_service.model.service;

import com.client_service.model.domain.Cliente;
import com.client_service.model.repository.ClienteRespository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRespository clienteRespository;

    public List<Cliente> buscarTodos(){
        return (ArrayList<Cliente>) clienteRespository.findAll();
    }

    public Cliente buscarPorId(Integer id){
        Optional<Cliente> cliente = clienteRespository.findById(id);
        if(cliente.isPresent()){
            return cliente.get();
        }
        throw new EntityNotFoundException("Id de cliente não encontrado.");
    }

    public Cliente salvar(Cliente cliente){
        return clienteRespository.save(cliente);
    }

    public Cliente excluir(Integer id){
        Cliente cliente = buscarPorId(id);
        clienteRespository.deleteById(id);
        return cliente;
    }

    public Cliente atualizar(int id, Cliente cliente){
        Cliente clienteAtual = buscarPorId(id);
        if(cliente.getNome() != null){ clienteAtual.setNome(cliente.getNome()); }
        if(cliente.getEndereco() != null){ clienteAtual.setEndereco(cliente.getEndereco()); }
        return clienteRespository.save(clienteAtual);
    }
}
