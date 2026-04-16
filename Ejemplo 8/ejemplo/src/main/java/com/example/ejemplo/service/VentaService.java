package com.example.ejemplo.service;

import com.example.ejemplo.entity.Venta;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface VentaService {
    List<Venta> getAllVenta();
    Venta getVentaById(Integer codigo_venta);
    Venta saveVenta (Venta venta) throws RuntimeException;
    Venta updateVenta (Integer codigo_venta, Venta venta);
    void deleteVenta (Integer codigo_venta);
}
