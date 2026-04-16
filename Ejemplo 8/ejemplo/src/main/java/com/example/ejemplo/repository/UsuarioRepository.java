package com.example.ejemplo.repository;

import com.example.ejemplo.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios,Integer> {

    Usuarios findByUsername(String username);
}
