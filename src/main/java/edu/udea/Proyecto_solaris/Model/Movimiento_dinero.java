package edu.udea.Proyecto_solaris.Model;


import java.util.ArrayList;

public class Movimiento_dinero {

    private double monto;
    private String concepto;
    private Empleado empleado;
    private long id;
    private Empresa empresa;
    public Movimiento_dinero(double monto, String concepto, Empleado empleado, long id, Empresa empresa) {
        this.monto = monto;
        this.concepto = concepto;
        this.empleado = empleado;
        this.id = id;
        this.empresa=empresa;
        //pendiente automatizar el consecutivo
    }

    public Movimiento_dinero() {
    }

    public double getMonto(long id) {return monto;}

    public void setMonto(long id, double monto) {
        this.monto = monto;
    }

    public String getConcepto(long id) {
        return concepto;
    }

    public void setConcepto(long id, String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEmpleado(long id) {
        return empleado;
    }

    public void setEmpleado(long id, Empleado empleado) {
        this.empleado = empleado;
    }
    public Empresa getEmpresa(long id) {
        return empresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmpresa(long id, Empresa empresa) {
        this.empresa = empresa;
    }
}
