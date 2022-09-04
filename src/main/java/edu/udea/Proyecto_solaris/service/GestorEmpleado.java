package edu.udea.Proyecto_solaris.service;

import edu.udea.Proyecto_solaris.Model.Empleado;
import edu.udea.Proyecto_solaris.Model.Empresa;
import edu.udea.Proyecto_solaris.Model.Movimiento_dinero;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class GestorEmpleado {
/*
    el sistema permite consultar (uno y varios), crear, editar y eliminar Usuarios de Empleados
    */
    private ArrayList<Empleado> empleados;

    public GestorEmpleado(){
        this.empleados = new ArrayList<>();
        this.empleados.add(new empleado("Prueba1", "Prueba","1234"));
        this.empleados.add(new empleado("Prueba1", "Andres","1234"));
    }

    public Empleado getEmpleado(String nombreEmpleado) throws Exception {
        for(Empleado empleado: this.empleados){
            if(empleado.getNombreEmpleado().equals(nombreEmpleado) ){
                return empleado;
            }
        }
        throw new Exception("Empleado No Existe");
    }

    //getAll

    public ArrayList<Empleado> getEmpleado()  {
            return empleado;
        }

    //hacer el set

    public String setEmpleado(Empleado empleado_parametro) throws Exception {
        try {
            //Consulta de existencia de empleado
            getEmpleado(empleado_parametro.getNombreEmpleado());
            } catch (Exception e) {
                // Codigo de crear un Empleado
                this.empleados.add(empleado_parametro);
                return "Creacion del usuario Exitosa";
            }
            //Error si el empleado ya existe
            throw new Exception("Emplado ya Existe");
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {this.empleados = empleados}

    public Empleado updateEmpleado(Empleado empleado_update, String id) throws Exception {
            try {
                Empleado empleado_bd = getEmpleado(id);

                if(empleado_update.getNombreEmpleado() != null && !empleado_update.getNombreEmpleado().equals("")){
                    empleado_bd.setNombreEmpleado(empleado_update.getNombreEmpleado());
                }

                if(empleado_update.getNombre() != null && !empleado_update.getNombre().equals("")){
                    empleado_bd.setNombre(empleado_update.getNombre());
                }

                if(empleado_update.getPassword() != null && !empleado_update.getPassword().equals("")) {
                    empleado_bd.setPassword(empleado_update.getPassword());
                }

                return empleado_bd;
            } catch (Exception e) {
                throw new Exception("Empleado NO existe, fallo actualización de datos");
            }
        }


        public Empleado updateEmpleadoAll(Empleado empleado_update, String id) throws Exception {
            try {
                Empleado empleado_bd = getEmpleado(id);

                empleado_bd.setNombreEmpleado(empleado_update.getNombreEmpleado());
                empleado_bd.setNombre(empleado_update.getNombre());
                empleado_bd.setPassword(empleado_update.getPassword());

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

        public String deleteEmpleado(String id) throws Exception {
            try {
                Empleado empleado = getEmpleado(id);

                this.empleados.remove(empleado);

                return "Empleado ELIMINADO exitosamente";
            } catch (Exception e) {
                throw new Exception("Empleado NO EXISTE, NO SE PUEDE  Eliminar");
            }
        }


    }

