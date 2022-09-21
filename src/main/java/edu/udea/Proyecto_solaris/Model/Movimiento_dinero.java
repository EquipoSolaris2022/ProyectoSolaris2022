package edu.udea.Proyecto_solaris.Model;


import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.*;
@Entity
@Table(name= "transacciones")
public class Movimiento_dinero {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name= "monto")
    private double monto;
    @Column(name="concepto")
    private String concepto;
    @ManyToOne
    @JoinColumn(name="IdEmpleado", referencedColumnName = "id")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name="IdEmpresa", referencedColumnName = "id")
    private Empresa empresa;
    @Column(name= "FechaCreacion")
    private LocalDate CreatedAt;
    @Column(name= "FechaActualizacion")
    private LocalDate UpdatedAt;
    public Movimiento_dinero(double monto, String concepto, Empleado empleado,  Empresa empresa) {
        this.monto = monto;
        this.concepto = concepto;
        this.empleado = empleado;
        this.empresa=empresa;
        this.CreatedAt= LocalDate.now();
    }

    public Movimiento_dinero() {
    }

    public long getId() {
        return id;
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

    public LocalDate getCreatedAt() {
        return CreatedAt;
    }

    public LocalDate getUpdatedAt() {
        return UpdatedAt;
    }

}
