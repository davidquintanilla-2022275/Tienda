package com.example.ejemplo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "codigo_venta")
    private Integer codigoventa;

    @Column (name = "fecha_total")
    private Date fechatotal;

    @Column (name = "total")
    private double total;

    @Column (name = "estado")
    private Integer estado;

    @Column (name = "dpi_cliente")
    private Integer dpi_cliente;

    @Column (name = "codigo_usuario")
    private Integer codigousuario;

    public Integer getCodigoventa() {
        return codigoventa;
    }

    public void setCodigoventa(Integer codigoventa) {
        this.codigoventa = codigoventa;
    }

    public Date getFechatotal() {
        return fechatotal;
    }

    public void setFechatotal(Date fechatotal) {
        this.fechatotal = fechatotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getDpi_cliente() {
        return dpi_cliente;
    }

    public void setDpi_cliente(Integer dpi_cliente) {
        this.dpi_cliente = dpi_cliente;
    }

    public Integer getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(Integer codigousuario) {
        this.codigousuario = codigousuario;
    }
}