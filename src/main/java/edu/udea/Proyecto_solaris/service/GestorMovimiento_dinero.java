package edu.udea.Proyecto_solaris.service;

import edu.udea.Proyecto_solaris.Model.Empresa;
import edu.udea.Proyecto_solaris.Model.Movimiento_dinero;
import edu.udea.Proyecto_solaris.Repositorio.Movimiento_dineroRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestorMovimiento_dinero {
    private Movimiento_dineroRepositorio repo;

    public GestorMovimiento_dinero(Movimiento_dineroRepositorio repo) {
        this.repo=repo;
    }

    public Movimiento_dinero getMovimiento(long id) throws Exception {
        Optional<Movimiento_dinero> movibd=repo.findById(id);
            if(movibd.isPresent()){
                return movibd.get();
            }
        throw new Exception("Movimiento no existe");
    }

    //hacer un getAll

    public List<Movimiento_dinero> getMovimientosByIDEmpresa(long id) throws Exception {
        try {
            return repo.findAllByempresa(id);
        }catch (Exception e){
            throw new Exception("Empresa No Existe" + e.getMessage());
        }
    }

    public String setMovimiento(long idEmpresa, Movimiento_dinero moviparam) throws Exception {
        repo.save(moviparam);
        return "Movimiento creado exitosamente";
    }



    //hacer el update parcial
    public Movimiento_dinero updateMovimiento(Movimiento_dinero movimientoact, long id) throws Exception {
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
            return repo.save(movimientoact);

    }

    //hacer el delete
    public String deleteMovimiento(long id) throws Exception {
        try {
            repo.deleteById(id);
            return "eliminado exitoso";
        }catch (Exception e){
            throw new Exception("Movimiento no existe para eliminar");
        }
    }





}



