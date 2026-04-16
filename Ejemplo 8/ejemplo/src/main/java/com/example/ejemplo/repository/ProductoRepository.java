package com.example.ejemplo.repository;

import com.example.ejemplo.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos,Integer>{
}
