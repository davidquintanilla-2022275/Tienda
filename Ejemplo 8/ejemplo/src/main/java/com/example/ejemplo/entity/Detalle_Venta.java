package com.example.ejemplo.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Detalle_Venta")
public class Detalle_Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_detalle_venta")
    private Integer codigodetalleventa;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_unitario")
    private double preciounitario;

    @Column (name = "subtotal")
    private double subtotal;

    @Column (name = "codigo_producto")
    private Integer codigoproducto;

    @Column (name = "codigo_venta")
    private Integer codigoventa;

    public Integer getCodigodetalleventa() {
        return codigodetalleventa;
    }

    public void setCodigodetalleventa(Integer codigodetalleventa) {
        this.codigodetalleventa = codigodetalleventa;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(Integer codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public Integer getCodigoventa() {
        return codigoventa;
    }

    public void setCodigoventa(Integer codigoventa) {
        this.codigoventa = codigoventa;
    }
}
