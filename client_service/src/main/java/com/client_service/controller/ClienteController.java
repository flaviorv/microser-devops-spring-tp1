package com.client_service.controller;

import com.client_service.model.domain.Cliente;
import com.client_service.model.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity buscarTodos() {
        try {
            return ResponseEntity.ok(clienteService.buscarTodos());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getCause().toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(clienteService.buscarPorId(id));
        }catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity adicionar(@RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(clienteService.salvar(cliente));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getCause().toString());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(clienteService.atualizar(id, cliente));
        }catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable int id) {
        try {
            return ResponseEntity.ok(clienteService.excluir(id));
        }catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
