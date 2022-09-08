package edu.udea.Proyecto_solaris.service;

import edu.udea.Proyecto_solaris.Model.Empleado;
import edu.udea.Proyecto_solaris.Model.Empresa;

import java.util.ArrayList;

public class GestorEmpresa {

    private ArrayList<Empresa> empresas;

    public GestorEmpresa(){
        this.empresas = new ArrayList<>();
        this.empresas.add(new Empresa(1,"empresa1","norte 1","12345","12345678"));
    }

    //Consultar todas las empresas
    public ArrayList<Empresa> getEmpresas(){
        return empresas;
    }

    //Consultar solo una empresa
    public Empresa getEmpresa(String NIT) throws Exception {
        for(Empresa empresa: this.empresas){
            if(empresa.getNIT().equals(NIT)){
                return empresa;
            }
        }
        throw new Exception("Empresa no existe");
    }

    //Crear una empresa
    public String setEmpresa(Empresa Empresa_parametro) throws Exception {
        try {
            getEmpresa(Empresa_parametro.getNombre());
        } catch (Exception e) {
            this.empresas.add(Empresa_parametro);
            return "Se creo la empresa correctamente";
        }
        throw new Exception("La empresa ya existe");
    }

    //Ediatr una empresa
    public Empresa updateEmpresa(Empresa empresa_update,long id) throws Exception {
        try {
            Empresa empresa_bd= getEmpresa(id);
            if(empresa_update.getDireccion() != null && !empresa_update.getDireccion().equals("")){
                empresa_bd.setDireccion(empresa_update.getDireccion());
            }
            if(empresa_update.getTelefono() != null && !empresa_update.getTelefono().equals("")){
                empresa_bd.setTelefono(empresa_update.getTelefono());
            }
            if(empresa_update.getNIT() != null && !empresa_update.getNIT().equals("")){
                empresa_bd.setNIT(empresa_update.getNIT());
            }
            return empresa_bd;

        } catch (Exception e) {
            throw new Exception("La empresa no existe, no se puede actualizar la informacion");
        }
    }

    //Eliminar una empresa
    public String deleteEmpresa(long id) throws Exception {
        try {
            Empresa empresa = getEmpresa(id);
            this.empresas.remove(empresa);
            return "Se elimino la empresa correctamente";
        } catch (Exception e) {
            throw new Exception("La empresa no existe no se puede eliminar");
        }
    }
    public Empresa getEmpresa(long id) throws Exception {
        for(Empresa empresa: this.empresas){
            if(empresa.getId()==id ){
                return empresa;
            }
        }
        throw new Exception("Empleado No Existe");
    }
}
