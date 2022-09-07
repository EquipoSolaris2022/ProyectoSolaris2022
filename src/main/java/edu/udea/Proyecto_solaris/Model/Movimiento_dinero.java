package edu.udea.Proyecto_solaris.Model;
import  edu.udea.Proyecto_solaris.Model.*;


public class Movimiento_dinero {

    private double monto;
    private String concepto;
    private Empleado empleado;
    private int consecutivo;
    private Empresa empresa;


    public Movimiento_dinero(double monto, String concepto, Empleado empleado, int consecutivo) {
        this.monto = monto;
        this.concepto = concepto;
        this.empleado = empleado;
        this.consecutivo=consecutivo;
        //pendiente automatizar el consecutivo
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

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
