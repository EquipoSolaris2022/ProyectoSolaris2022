package edu.udea.Proyecto_solaris.service;

import edu.udea.Proyecto_solaris.Model.Empleado;
import edu.udea.Proyecto_solaris.Model.Empresa;
import edu.udea.Proyecto_solaris.Model.Movimiento_dinero;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class GestorMovimiento_dinero {
/*
    el sistema permite
    el sistema permite consultar (uno y varios), crear, editar y eliminar movimiento de dinero
    */
    private ArrayList<Movimiento_dinero> movimientos;
    private ArrayList<Empresa> empresas;
    private ArrayList<Empleado> empleados;
    public GestorMovimiento_dinero() {
        this.movimientos=new ArrayList<>();
        this.empresas = new ArrayList<>();
        this.empleados = new ArrayList<>();
        empresas.add(new Empresa(1,"empresa1","norte 1","12345","12345678"));
        empresas.add(new Empresa(2,"empresa2","norte 2","12345","99887766"));

        empleados.add(new Empleado(1,"Prueba1", "Prueba", empresas.get(0),"operador"));
        empleados.add(new Empleado(2,"Prueba2", "Prueba2", empresas.get(0),"operador"));
        empleados.add(new Empleado(3,"Prueba3", "Prueba3", empresas.get(1),"operador"));

        movimientos.add(new Movimiento_dinero(1,10000,"ingreso",empleados.get(0),empresas.get(0)));
        movimientos.add(new Movimiento_dinero(2,20000,"egreso",empleados.get(1),empresas.get(0)));
        movimientos.add(new Movimiento_dinero(3,30000,"ingreso",empleados.get(2),empresas.get(1)));
    }

    public Movimiento_dinero getMovimiento(long id) throws Exception {
        for(Movimiento_dinero movimiento:this.movimientos){
            if(movimiento.getId()==id){
                return movimiento;
            }
        }
        throw new Exception("Movimiento no existe");
    }

    //hacer un getAll

    public ArrayList<Movimiento_dinero> getMovimientos(long idEmpresa)  throws Exception{
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
            throw new Exception("Empresa No Existe" + e.getMessage());
        }
    }
    public ArrayList<Movimiento_dinero> setMovimiento(long idempresa, Movimiento_dinero moviparam) throws Exception {
        try {
            Empleado empleado = new Empleado();
            long id = (long) ((Math.random() * (100000 - 1)) + 1);
            for (Empleado trabajador: this.empleados) {
                if(trabajador.getId() == moviparam.getId_empleado()){
                    empleado = trabajador;
                    for (Empresa empresa: this.empresas) {
                        if(empresa.getId() == idempresa){
                            this.movimientos.add(new Movimiento_dinero(id,moviparam.getMonto(),moviparam.getConcepto(),empleado,empresa));

                        }
                    }

                }
            }
            return movimientos;
        }catch (Exception e){
            throw new Exception("Empleado No Existe" + e.getMessage());
        }
    }



    //hacer el update parcial
    public Movimiento_dinero updateMovimiento(Movimiento_dinero movimientoact, long id) throws Exception {
        try {
            Movimiento_dinero movi =getMovimiento(id);
            if(movimientoact.getMonto() != 0){
                movi.setMonto(movimientoact.getMonto());
            }
            if(movimientoact.getConcepto() != null && !movimientoact.getConcepto().equals("")){
                movi.setConcepto(movimientoact.getConcepto());
            }
            if(movimientoact.getEmpleado() != null){
                movi.setEmpleado(movimientoact.getEmpleado());
            }
            return movi;
        }catch (Exception e){
            throw new Exception("movimiento no existe, fallo actualización");
        }
    }

    //hacer el delete
    public String deleteMovimiento(long id) throws Exception {
        try {
            Movimiento_dinero movidel=getMovimiento(id);
            this.movimientos.remove(movidel);
            return "eliminado exitoso";
        }catch (Exception e){
            throw new Exception("Movimiento no existe para eliminar");
        }
    }





}



