package edu.udea.Proyecto_solaris.Model;

import java.util.List;
import  edu.udea.Proyecto_solaris.Model.*;
import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table(name= "empleado")
public class Empleado {
    @Id
    private long id;
    @Column(name= "nombre")
    private String nombre;
    @Column(name= "correo")
    private String correo;
    @OneToMany(mappedBy = "empleado")
    private List<Movimiento_dinero> transacciones;
    @ManyToOne
    private Empresa empresa;
    private String rol;

    public Empleado(long id, String nombre, String correo, Empresa empresa, String rol) {
        this.id=id;
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
    }

    public Empleado() {
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
