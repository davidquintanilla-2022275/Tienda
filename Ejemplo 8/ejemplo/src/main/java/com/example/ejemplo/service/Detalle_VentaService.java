package com.example.ejemplo.service;

import com.example.ejemplo.entity.Detalle_Venta;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface Detalle_VentaService {
    List<Detalle_Venta> getAllDetalle_Venta();
    Detalle_Venta getDetalle_VentaById(Integer codigo_detalle_venta);
    Detalle_Venta saveDetalle_Venta (Detalle_Venta detalle_venta)throws RuntimeException;
    Detalle_Venta updateDetalle_Venta (Integer codigo_detalle_venta, Detalle_Venta detalle_venta);
    void deleteDetalle_Venta (Integer codigo_detalle_venta);
}
