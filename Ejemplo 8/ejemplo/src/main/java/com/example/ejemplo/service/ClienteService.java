package com.example.ejemplo.service;

import com.example.ejemplo.entity.Clientes;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ClienteService {
    List<Clientes> getAllClientes();
    Clientes getClientesById(Integer dqp_cliente);
    Clientes saveClientes(Clientes clientes) throws RuntimeException;
    Clientes updateClientes(Integer dpi_cliente, Clientes clientes);
    void deleteClientes (Integer dpi_cliente);
}
