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
    private ArrayList<Empresa> empresa;
    public GestorMovimiento_dinero() {
        this.movimientos=new ArrayList<>();
        Empresa MisionTIC =new Empresa(1,"empresa1","norte 1","12345","12345678");
        Empleado Andres=new Empleado(1,"andres", "andrestapia@gmail.com",MisionTIC,"administrador" );
        this.movimientos.add(new Movimiento_dinero(100,"gasto",Andres,1,MisionTIC));
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

    public ArrayList<Movimiento_dinero> getMovimientos()  {
        return movimientos;
    }
    public String setMovimiento(Movimiento_dinero moviparam) throws Exception {
        try {
            //Consulta de existencia de usuario
            getMovimiento(moviparam.getId());
        } catch (Exception e) {
            // Codigo de crear un movimiento
            this.movimientos.add(moviparam);
            return "Creacion del movimiento Exitosa";
        }
        //Error si el movimiento ya existe
        throw new Exception("Movimiento Existe");
    }

    public void setMovimientos(ArrayList<Movimiento_dinero> movimientos) {this.movimientos = movimientos;}

    //hacer el update parcial
    public Movimiento_dinero updateMovimiento(Movimiento_dinero movimientoact, long id) throws Exception {
        try {
            Movimiento_dinero movi =getMovimiento(id);
            if(movimientoact.getMonto(id) != 0){
                movi.setMonto(id,movimientoact.getMonto(id));
            }
            if(movimientoact.getConcepto(id) != null){
                movi.setConcepto(id,movimientoact.getConcepto(id));
            }
            if(movimientoact.getEmpleado(id) != null){
                movi.setEmpleado(id,movimientoact.getEmpleado(id));
            }
            return movi;
        }catch (Exception e){
            throw new Exception("movimiento no existe, fallo actualización");
        }
    }

    //hacer el updpate total
    public Movimiento_dinero updateMovimientoAll(Movimiento_dinero movimientoact, long id) throws Exception {
        try {
            Movimiento_dinero movi =getMovimiento(id);
            movi.setMonto(id,movimientoact.getMonto(id));
            movi.setConcepto(id,movimientoact.getConcepto(id));
            movi.setEmpleado(id,movimientoact.getEmpleado(id));
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



