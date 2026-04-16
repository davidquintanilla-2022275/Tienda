package com.example.ejemplo.controller;

import com.example.ejemplo.entity.Detalle_Venta;
import com.example.ejemplo.service.Detalle_VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle_venta")
public class Detalle_VentaController {

    private final Detalle_VentaService detalleService;

    public Detalle_VentaController(Detalle_VentaService detalleService) {
        this.detalleService = detalleService;
    }

    @GetMapping
    public List<Detalle_Venta> getAllDetalle_Venta() {
        return detalleService.getAllDetalle_Venta();
    }

    @PostMapping
    public ResponseEntity<Object> createDetalle(@RequestBody Detalle_Venta detalle) {
        try {
            return new ResponseEntity<>(detalleService.saveDetalle_Venta(detalle), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDetalleById(@PathVariable Integer id) {
        return ResponseEntity.ok(detalleService.getDetalle_VentaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle_Venta> updateDetalle(@PathVariable Integer id, @RequestBody Detalle_Venta detalle) {
        return ResponseEntity.ok(detalleService.updateDetalle_Venta(id, detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDetalle(@PathVariable Integer id) {
        detalleService.deleteDetalle_Venta(id);
        return ResponseEntity.noContent().build();
    }
}