package com.example.ejemplo.service;

import com.example.ejemplo.entity.Clientes;
import com.example.ejemplo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplement implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImplement(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Clientes> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Clientes getClientesById(Integer dpi_cliente) {
        return clienteRepository.findById(dpi_cliente).orElse(null);
    }

    @Override
    public Clientes saveClientes(Clientes clientes) throws RuntimeException {
        return clienteRepository.save(clientes);
    }

    @Override
    public Clientes updateClientes(Integer dpi_cliente, Clientes clientes) {

        Clientes clienteExistente = clienteRepository.findById(dpi_cliente).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con id: " + dpi_cliente));
        clienteExistente.setNombrecliente(clientes.getNombrecliente());
        clienteExistente.setApellidocliente(clientes.getApellidocliente());
        clienteExistente.setDireccion(clientes.getDireccion());
        clienteExistente.setEstado(clientes.getEstado());

        return clienteRepository.save(clienteExistente);
    }

    @Override
    public void deleteClientes(Integer dpi_cliente) {
        clienteRepository.deleteById(dpi_cliente);
    }
}
