package com.example.ejemplo.service;

import com.example.ejemplo.entity.Productos;
import java.util.List;

public interface ProductosService {
    List<Productos> getAllproductos();
    Productos getproductosById(Integer codigo_producto);
    Productos saveproductos(Productos productos) throws RuntimeException;
    Productos updateproductos (Integer codigo_producto, Productos productos);
    void deleteproductos (Integer codigo_producto);
}
