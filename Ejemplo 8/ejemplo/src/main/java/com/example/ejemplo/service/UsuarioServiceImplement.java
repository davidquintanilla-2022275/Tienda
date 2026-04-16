package com.example.ejemplo.service;

import com.example.ejemplo.entity.Usuarios;
import com.example.ejemplo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImplement(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuarios> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuarios getUsuariosByid(Integer codigo_usuario) {
        return usuarioRepository.findById(codigo_usuario).orElse(null);
    }

    @Override
    public Usuarios saveUsuarios(Usuarios usuarios) throws RuntimeException {
        return usuarioRepository.save(usuarios);
    }

    @Override
    public Usuarios updateUsuarios(Integer codigo_usuarios, Usuarios usuarios) {

        Usuarios usuarioExistente = usuarioRepository.findById(codigo_usuarios).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + codigo_usuarios));
        usuarioExistente.setUsername(usuarios.getUsername());
        usuarioExistente.setPasword(usuarios.getPasword());
        usuarioExistente.setEmail(usuarios.getEmail());
        usuarioExistente.setRol(usuarios.getRol());
        usuarioExistente.setEstado(usuarios.getEstado());

        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void deleteUsuarios(Integer codigo_usuario) {
        usuarioRepository.deleteById(codigo_usuario);
    }

    @Override
    public Usuarios registrar(String usuarios, String password) {
        return null;
    }

    @Override
    public Usuarios login(String username, String password) {

        Usuarios u = usuarioRepository.findByUsername(username);

        if (u != null && u.getPasword().equals(password)) {
            return u;
        }

        return null;
    }

    @Override
    public List<Usuarios> listar() {
        return List.of();
    }

    @Override
    public void eliminar(int id) {

    }
}
