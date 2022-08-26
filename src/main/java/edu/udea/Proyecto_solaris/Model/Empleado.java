package edu.udea.Proyecto_solaris.Model;

import java.util.List;

public class Empleado {

    private int id;
    private String nombre;
    private String correo;
    private Empresa empresa;
    private String rol;

    private List<Movimiento_dinero> transacciones;
    public Empleado(String nombre, String correo, Empresa empresa, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Movimiento_dinero> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Movimiento_dinero> transacciones) {
        this.transacciones = transacciones;
    }
}
