package com.example.ejemplo.service;

import com.example.ejemplo.entity.Venta;
import com.example.ejemplo.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImplement implements VentaService {

    private final VentaRepository ventaRepository;

    public VentaServiceImplement(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> getAllVenta() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Integer codigo_venta) {
        return ventaRepository.findById(codigo_venta).orElse(null);
    }

    @Override
    public Venta saveVenta(Venta venta) throws RuntimeException {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta updateVenta(Integer codigo_venta, Venta venta) {

        Venta ventaExistente = ventaRepository.findById(codigo_venta).orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con id: " + codigo_venta));
        ventaExistente.setFechatotal(venta.getFechatotal());
        ventaExistente.setTotal(venta.getTotal());
        ventaExistente.setEstado(venta.getEstado());
        ventaExistente.setDpi_cliente(venta.getDpi_cliente());
        ventaExistente.setCodigousuario(venta.getCodigousuario());

        return ventaRepository.save(ventaExistente);
    }

    @Override
    public void deleteVenta(Integer codigo_venta) {
        ventaRepository.deleteById(codigo_venta);
    }
}
