package com.example.ejemplo.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "codigo_producto")
    private Integer codigoproducto;

    @Column (name = "nombre_producto")
    private String nombreproducto;

    @Column (name = "precio")
    private Double precio;

    @Column (name = "stok")
    private Integer stok;

    @Column (name = "estado")
    private Integer estado;

    public Integer getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(Integer codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
