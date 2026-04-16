package com.example.ejemplo.controller;

import com.example.ejemplo.entity.Clientes;
import com.example.ejemplo.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesControlles {

    private final ClienteService clienteService;

    public ClientesControlles(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Clientes> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PostMapping
    public ResponseEntity<Object> createCliente(@RequestBody Clientes clientes) {
        try {
            return new ResponseEntity<>(clienteService.saveClientes(clientes), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClienteById(@PathVariable Integer id) {
        Clientes cliente = clienteService.getClientesById(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> updateCliente(@PathVariable Integer id, @RequestBody Clientes clientes) {
        return ResponseEntity.ok(clienteService.updateClientes(id, clientes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable Integer id) {
        clienteService.deleteClientes(id);
        return ResponseEntity.noContent().build();
    }
}