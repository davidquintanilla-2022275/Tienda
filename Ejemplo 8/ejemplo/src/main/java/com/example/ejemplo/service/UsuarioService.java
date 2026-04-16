package com.example.ejemplo.service;

import com.example.ejemplo.entity.Usuarios;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UsuarioService {
    List<Usuarios> getAllUsuario();
    Usuarios getUsuariosByid(Integer codigo_usuario);
    Usuarios saveUsuarios (Usuarios usuarios) throws RuntimeException;
    Usuarios updateUsuarios (Integer codigo_usuarios, Usuarios usuarios);
    void deleteUsuarios (Integer codigo_usuario);

    Usuarios registrar(String usuarios, String password);
    Usuarios login (String usuarios , String password);
    List<Usuarios> listar();
    void eliminar(int id);
}

