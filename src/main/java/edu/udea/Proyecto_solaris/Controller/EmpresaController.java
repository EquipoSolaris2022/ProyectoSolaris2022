package edu.udea.Proyecto_solaris.Controller;

import edu.udea.Proyecto_solaris.Model.Empleado;
import edu.udea.Proyecto_solaris.Model.Empresa;
import edu.udea.Proyecto_solaris.Model.ObjetoRespuesta;
import edu.udea.Proyecto_solaris.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class EmpresaController {

    GestorEmpresa gestorEmpresa = new GestorEmpresa();

    @GetMapping("/enterprises")
    public ResponseEntity<ArrayList<Empresa>> getEmpresas(){
        return new ResponseEntity<>(gestorEmpresa.getEmpresas(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/enterprises")
    public ResponseEntity<String> postEmpresa(@RequestBody Empresa empresa) {
        try {
            String mensaje = gestorEmpresa.setEmpresa(empresa);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/enterprises/{NIT}")

    public ResponseEntity<Empresa> getEmpresaPath (@PathVariable String NIT) throws Exception {
        return new ResponseEntity<>(gestorEmpresa.getEmpresa(NIT), HttpStatus.OK);
    }

    @GetMapping("/enterprises/{id}")

    public ResponseEntity<Empresa> getEmpresaPath (@PathVariable long id) throws Exception {
        return new ResponseEntity<>(gestorEmpresa.getEmpresa(id), HttpStatus.OK);
    }
    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity <ObjetoRespuesta> deleteUsuario(@PathVariable long id){
        try {
            String mensaje = gestorEmpresa.deleteEmpresa(id);

            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/enterprises/{id}")
    public ResponseEntity <ObjetoRespuesta> patchUsuario(@RequestBody Empresa empresa, @PathVariable long id) {
        try {
            Empresa enteprise = gestorEmpresa.updateEmpresa(empresa, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", enteprise), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
