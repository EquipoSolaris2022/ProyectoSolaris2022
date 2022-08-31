package edu.udea.Proyecto_solaris.Model;

import java.util.List;

public class Empresa {
    private long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;

    private List<Empleado> empleados;

    private List<Movimiento_dinero> transacciones;

    public Empresa(String nombre, String direccion, String telefono, String NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Movimiento_dinero> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Movimiento_dinero> transacciones) {
        this.transacciones = transacciones;
    }
}
