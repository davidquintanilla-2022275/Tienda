package com.example.ejemplo.service;

import com.example.ejemplo.entity.Detalle_Venta;
import com.example.ejemplo.repository.Detalle_VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Detalle_VentaServiceImplement implements Detalle_VentaService {

    private final Detalle_VentaRepository detalleVentaRepository;

    public Detalle_VentaServiceImplement(Detalle_VentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public List<Detalle_Venta> getAllDetalle_Venta() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public Detalle_Venta getDetalle_VentaById(Integer codigo_detalle_venta) {
        return detalleVentaRepository.findById(codigo_detalle_venta).orElse(null);
    }

    @Override
    public Detalle_Venta saveDetalle_Venta(Detalle_Venta detalle_venta) throws RuntimeException {
        return detalleVentaRepository.save(detalle_venta);
    }

    @Override
    public Detalle_Venta updateDetalle_Venta(Integer codigo_detalle_venta, Detalle_Venta detalle_venta) {

        Detalle_Venta detalleExistente = detalleVentaRepository.findById(codigo_detalle_venta).orElseThrow(() -> new IllegalArgumentException("Detalle venta no encontrado con id: " + codigo_detalle_venta));
        detalleExistente.setCantidad(detalle_venta.getCantidad());
        detalleExistente.setPreciounitario(detalle_venta.getPreciounitario());
        detalleExistente.setSubtotal(detalle_venta.getSubtotal());
        detalleExistente.setCodigoproducto(detalle_venta.getCodigoproducto());
        detalleExistente.setCodigoventa(detalle_venta.getCodigoventa());

        return detalleVentaRepository.save(detalleExistente);
    }

    @Override
    public void deleteDetalle_Venta(Integer codigo_detalle_venta) {
        detalleVentaRepository.deleteById(codigo_detalle_venta);
    }
}
