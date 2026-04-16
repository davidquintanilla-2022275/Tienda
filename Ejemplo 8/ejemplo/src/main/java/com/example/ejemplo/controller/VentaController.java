package com.example.ejemplo.controller;

import com.example.ejemplo.entity.Venta;
import com.example.ejemplo.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public List<Venta> getAllVenta() {
        return ventaService.getAllVenta();
    }

    @PostMapping
    public ResponseEntity<Object> createVenta(@RequestBody Venta venta) {
        try {
            return new ResponseEntity<>(ventaService.saveVenta(venta), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVentaById(@PathVariable Integer id) {
        return ResponseEntity.ok(ventaService.getVentaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Integer id, @RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.updateVenta(id, venta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVenta(@PathVariable Integer id) {
        ventaService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }
}