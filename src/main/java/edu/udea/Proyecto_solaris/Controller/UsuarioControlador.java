package edu.udea.Proyecto_solaris.Controller;


import edu.udea.Proyecto_solaris.Model.*;
import edu.udea.Proyecto_solaris.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControlador {
    GestorEmpleado gestorUsuario = new GestorEmpleado();

    @GetMapping("/users")
    public ResponseEntity <ArrayList<Empleado>> getUsuarios(){
        return new ResponseEntity<>(gestorUsuario.getEmpleados(), HttpStatus.ACCEPTED);

    }

    @PostMapping("/users")
    public ResponseEntity<String> postUsuarios(@RequestBody Empleado usuario) {
        try {
            String mensaje = gestorUsuario.setEmpleado(usuario);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario/{id}")

    public ResponseEntity<String> getUsuarioPath (@PathVariable String id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity <ObjetoRespuesta> deleteUsuario(@PathVariable String nombre){
        try {
            String mensaje = gestorUsuario.deleteEmpleado(nombre);

            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping("/usuario/{id}")
    public ResponseEntity <ObjetoRespuesta> patchUsuario(@RequestBody Empleado useri, @PathVariable String id) {
        try {
            Empleado user = gestorUsuario.updateEmpleado(useri, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

