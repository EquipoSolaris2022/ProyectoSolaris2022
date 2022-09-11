package edu.udea.Proyecto_solaris.service;

import edu.udea.Proyecto_solaris.Model.*;

import java.util.ArrayList;
import java.util.Random;

public class GestorMovimientoDinero {

    private ArrayList<Empresa> empresas;
    private ArrayList<Empleado> empleados;
    private ArrayList<Movimiento_dinero> movimientos;


    public GestorMovimientoDinero (){

        this.empresas = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.movimientos = new ArrayList<>();

        empresas.add(new Empresa(1,"empresa1","norte 1","12345","12345678"));
        empresas.add(new Empresa(2,"empresa2","norte 2","12345","99887766"));

        empleados.add(new Empleado(1,"Prueba1", "Prueba", empresas.get(0),"operador"));
        empleados.add(new Empleado(2,"Prueba2", "Prueba2", empresas.get(0),"operador"));
        empleados.add(new Empleado(3,"Prueba3", "Prueba3", empresas.get(1),"operador"));

        movimientos.add(new Movimiento_dinero(1,10000,"ingreso",empleados.get(0),empresas.get(0)));
        movimientos.add(new Movimiento_dinero(2,20000,"egreso",empleados.get(1),empresas.get(0)));
        movimientos.add(new Movimiento_dinero(3,30000,"ingreso",empleados.get(2),empresas.get(1)));

    }

    public ArrayList<Movimiento_dinero> getMovimientos(long idEmpresa) throws Exception{

        try {
            ArrayList<Movimiento_dinero> dinero;
            dinero = new ArrayList<>();
            for (Movimiento_dinero movimiento: this.movimientos) {

                if(movimiento.getEmpresa().getId() == idEmpresa ){
                    movimiento.getEmpleado().setEmpresa(null);
                    dinero.add(movimiento);
                }
            }
            return dinero;
        }catch (Exception e){
            throw new Exception("Movimiento No Existe" + e.getMessage());
        }
    }


    public ArrayList<Movimiento_dinero> postMovimiento(long id_empresa,Movimiento_dinero movimiento) throws Exception{

        try {
            Empleado empleado = new Empleado();
            long id = (long) ((Math.random() * (100000 - 1)) + 1);
            for (Empleado trabajador: this.empleados) {
                if(trabajador.getId() == movimiento.getId_empleado()){
                    empleado = trabajador;
                    for (Empresa empresa: this.empresas) {
                        if(empresa.getId() == id_empresa){
                            this.movimientos.add(new Movimiento_dinero(id,movimiento.getMonto(),movimiento.getConcepto(),empleado,empresa));

                        }
                    }

                }
            }
            return movimientos;
        }catch (Exception e){
            throw new Exception("Empleado No Existe" + e.getMessage());
        }
    }

    public Movimiento_dinero updateMovimiento(Movimiento_dinero movimiento,long id) throws Exception {

        try {

            Movimiento_dinero movimiento_bd = getMovimiento(id);

            if (movimiento.getMonto() != 0 ){
                movimiento_bd.setMonto(movimiento.getMonto());
            }
            if (movimiento.getConcepto() != null && !movimiento.getConcepto().equals("")){
                movimiento_bd.setConcepto(movimiento.getConcepto());
            }

            return movimiento_bd;

        } catch (Exception e) {
            throw new Exception("El movimiento no existe, no se puede actualizar la informacion");
        }
    }



    public Movimiento_dinero getMovimiento(long id) throws Exception {
        for(Movimiento_dinero movimiento: this.movimientos){
            if(movimiento.getId()==id ){
                return movimiento;
            }
        }
        throw new Exception("Moovimiento No Existe");
    }

    public String deleteMovimiento(long id) throws Exception {
        try {
            Movimiento_dinero movimiento = getMovimiento(id);
            this.movimientos.remove(movimiento);
            return "Se elimino el movimiento correctamente";
        } catch (Exception e) {
            throw new Exception("El movimiento no existe no se puede eliminar");
        }
    }



}
