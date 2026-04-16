package com.example.ejemplo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpi_cliente")
    private Integer dpicliente;

    @Column(name = "nombre_cliente")
    private String nombrecliente;

    @Column(name = "apellido_cliente")
    private String apellidocliente;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "estado")
    private Integer estado;

    public Clientes() {}

    public Integer getDpicliente() {
        return dpicliente;
    }

    public void setDpicliente(Integer dpicliente) {
        this.dpicliente = dpicliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getApellidocliente() {
        return apellidocliente;
    }

    public void setApellidocliente(String apellidocliente) {
        this.apellidocliente = apellidocliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}