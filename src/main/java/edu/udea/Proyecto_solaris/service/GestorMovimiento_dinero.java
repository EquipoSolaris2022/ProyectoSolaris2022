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
    public GestorMovimiento_dinero() {
        this.movimientos=new ArrayList<>();
        // se deben añadir los movimientos de prueba
        Empresa MisionTIC =new Empresa("misiontic", "calle 1",316, 901 );
        Empleado Andres=new Empleado("andres", "andrestapia@gmail.com",MisionTIC,"administrador" );
        this.movimientos.add(new Movimiento_dinero(100,"gasto",Andres,1));
    }
    //hacer el get pero se necesita un ID para el
    public Movimiento_dinero getMovimiento(int consecutivo) throws Exception {
        for(Movimiento_dinero movimiento:this.movimientos){
            if(movimiento.getConsecutivo()==consecutivo){
                return movimiento;
            }
        }
        throw new Exception("Movimiento no existe");
    }

    //hacer un getAll

    public ArrayList<Movimiento_dinero> getMovimientos()  {
        return movimientos;
    }
    //hacer el set
    public String setMovimiento(Movimiento_dinero moviparam) throws Exception {
        try {
            //Consulta de existencia de usuario
            getMovimiento(moviparam.getConsecutivo());
        } catch (Exception e) {
            // Codigo de crear un usuario
            this.movimientos.add(moviparam);
            return "Creacion del usuario Exitosa";
        }
        //Error si el usuario ya existe
        throw new Exception("Usuario Existe");
    }

    public void setUsuarios(ArrayList<Movimiento_dinero> movimientos) {this.movimientos = movimientos;}

    //hacer el update parcial
    public Movimiento_dinero updateMovimiento(Movimiento_dinero movimientoact, int consecutivo) throws Exception {
        try {
            Movimiento_dinero movi =getMovimiento(consecutivo);
            if(movimientoact.getMonto() != 0){
                movi.setMonto(movimientoact.getMonto());
            }
            if(movimientoact.getConcepto() != null){
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

    //hacer el updpate total
    public Movimiento_dinero updateMovimientoAll(Movimiento_dinero movimientoact, int consecutivo) throws Exception {
        try {
            Movimiento_dinero movi =getMovimiento(consecutivo);
            movi.setMonto(movimientoact.getMonto());
            movi.setConcepto(movimientoact.getConcepto());
            movi.setEmpleado(movimientoact.getEmpleado());
            return movi;
        }catch (Exception e){
            throw new Exception("movimiento no existe, fallo actualización");
        }
    }


    //hacer el delete
    public String deleteMovimiento(int consecutivo) throws Exception {
        try {
            Movimiento_dinero movidel=getMovimiento(consecutivo);
            this.movimientos.remove(movidel);
            return "eliminado exitoso";
        }catch (Exception e){
            throw new Exception("Movimiento no existe para eliminar");
        }
    }

}



