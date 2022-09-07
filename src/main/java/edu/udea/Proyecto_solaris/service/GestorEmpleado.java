package edu.udea.Proyecto_solaris.service;

import edu.udea.Proyecto_solaris.Model.*;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class GestorEmpleado {
/*
    el sistema permite consultar (uno y varios), crear, editar y eliminar Usuarios de Empleados
    */
    private ArrayList<Empleado> empleados;
    private ArrayList<Empresa> empresa;

    public GestorEmpleado(){
        this.empresa = new ArrayList<>();
        this.empleados = new ArrayList<>();

        //String nombre, String direccion, String telefono, String NIT

        this.empresa.add(new Empresa("empresa1", "calle falsa 123", "3111111", "123456789"));

        this.empleados.add(new Empleado(1111111,"Prueba1", "Prueba", empresa.get(0),"operador"));
        this.empleados.add(new Empleado(2222222,"Prueba1", "Andres", empresa.get(0), "admin"));
    }

    public Empleado getEmpleado(long id) throws Exception {
        for(Empleado empleado: this.empleados){
            if(empleado.getId()==id ){
                return empleado;
            }
        }
        throw new Exception("Empleado No Existe");
    }

    //getAll

    public ArrayList<Empleado> getEmpleado()  {
            return empleados;
        }

    //hacer el set

    public String setEmpleado(Empleado empleado_parametro) throws Exception {
        try {
            //Consulta de existencia de empleado
            getEmpleado(empleado_parametro.getId());
            } catch (Exception e) {
                // Codigo de crear un Empleado
                this.empleados.add(empleado_parametro);
                return "Creacion del usuario Exitosa";
            }
            //Error si el empleado ya existe
            throw new Exception("Emplado ya Existe");
    }

    //public void setEmpleados(ArrayList<Empleado> empleados) {this.empleados = empleados;}
    //public void setUsuarios(ArrayList<Movimiento_dinero> movimientos) {this.movimientos = movimientos;}

    public Empleado updateEmpleado(Empleado empleado_update, long id) throws Exception {
            try {
                Empleado empleado_bd = getEmpleado(id);

                if(empleado_update.getNombre() != null && !empleado_update.getNombre().equals("")){
                    empleado_bd.setNombre(empleado_update.getNombre());
                }

                if(empleado_update.getCorreo() != null && !empleado_update.getCorreo().equals("")){
                    empleado_bd.setCorreo(empleado_update.getCorreo());
                }


                return empleado_bd;
            } catch (Exception e) {
                throw new Exception("Empleado NO existe, fallo actualización de datos");
            }
        }


        public Empleado updateEmpleadoAll(Empleado empleado_update, long id) throws Exception {
            try {
                Empleado empleado_bd = getEmpleado(id);

                empleado_bd.setNombre(empleado_update.getNombre());
                empleado_bd.setCorreo(empleado_update.getCorreo());


                return empleado_bd;
            } catch (Exception e) {
                throw new Exception("Empleado NO existe, fallo actualización de datos");
            }
        }

        public ArrayList<Empleado> getEmpleados() {
            return empleados;
        }

        public void setEmpleados(ArrayList<Empleado> empleados) {
            this.empleados = empleados;
        }

        public String deleteEmpleado(long id) throws Exception {
            try {
                Empleado empleado = getEmpleado(id);

                this.empleados.remove(empleado);

                return "Empleado ELIMINADO exitosamente";
            } catch (Exception e) {
                throw new Exception("Empleado NO EXISTE, NO SE PUEDE  Eliminar");
            }
        }


    }

