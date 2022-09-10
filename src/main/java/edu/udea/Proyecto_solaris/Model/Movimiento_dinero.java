package edu.udea.Proyecto_solaris.Model;


import java.util.ArrayList;

public class Movimiento_dinero {

    private long id;
    private double monto;
    private String concepto;
    private Empleado empleado;

    private Empresa empresa;

    private long id_empleado;
    public Movimiento_dinero(long id,double monto, String concepto, Empleado empleado,  Empresa empresa) {
        this.id = id;
        this.monto = monto;
        this.concepto = concepto;
        this.empleado = empleado;
        this.empresa=empresa;

    }
    public Movimiento_dinero(long id,double monto, String concepto, long id_empleado) {
        this.id = id;
        this.monto = monto;
        this.concepto = concepto;
        this.id_empleado =   id_empleado;
    }


    public Movimiento_dinero() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    public long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }
}
