package com.example.ejemplo.controller;

import com.example.ejemplo.entity.Productos;
import com.example.ejemplo.service.ProductosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public List<Productos> getAllproductos() {
        return productosService.getAllproductos();
    }

    @PostMapping
    public ResponseEntity<Object> createProducto(@RequestBody Productos productos) {
        try {
            return new ResponseEntity<>(productosService.saveproductos(productos), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductoById(@PathVariable Integer id) {
        return ResponseEntity.ok(productosService.getproductosById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> updateProducto(@PathVariable Integer id, @RequestBody Productos productos) {
        return ResponseEntity.ok(productosService.updateproductos(id, productos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProducto(@PathVariable Integer id) {
        productosService.deleteproductos(id);
        return ResponseEntity.noContent().build();
    }
}
