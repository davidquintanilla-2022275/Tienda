package com.example.ejemplo.repository;

import com.example.ejemplo.entity.Detalle_Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalle_VentaRepository extends JpaRepository<Detalle_Venta,Integer> {
}
