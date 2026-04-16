package com.example.ejemplo.service;

import com.example.ejemplo.entity.Productos;
import com.example.ejemplo.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductosServiceImplement implements ProductosService {

    private final ProductoRepository productosRepository;

    public ProductosServiceImplement(ProductoRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> getAllproductos() {
        return productosRepository.findAll();
    }

    @Override
    public Productos getproductosById(Integer codigo_producto) {
        return productosRepository.findById(codigo_producto).orElse(null);
    }

    @Override
    public Productos saveproductos(Productos productos) throws RuntimeException {
        return productosRepository.save(productos);
    }

    @Override
    public Productos updateproductos(Integer codigo_producto, Productos productos) {

        Productos productoExistente = productosRepository.findById(codigo_producto).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id: " + codigo_producto));

        productoExistente.setNombreproducto(productos.getNombreproducto());
        productoExistente.setPrecio(productos.getPrecio());
        productoExistente.setStok(productos.getStok());
        productoExistente.setEstado(productos.getEstado());

        return productosRepository.save(productoExistente);
    }

    @Override
    public void deleteproductos(Integer codigo_producto) {
        productosRepository.deleteById(codigo_producto);
    }
}
