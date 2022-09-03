package edu.udea.Proyecto_solaris.Controller;

import edu.udea.Proyecto_solaris.Model.ObjetoRespuesta;
import edu.udea.Proyecto_solaris.Model.Usuario;
import edu.udea.Proyecto_solaris.bussiness.GestorUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControlador {
    GestorUsuario gestorUsuario = new GestorUsuario();

    @GetMapping("/usuarios")
    public ResponseEntity <ArrayList<Usuario>> getUsuarios(){
        return new ResponseEntity<>(gestorUsuario.getUsuarios(), HttpStatus.ACCEPTED);

    }

    @PostMapping("/usuarios")
    public ResponseEntity<String> postUsuarios(@RequestBody Usuario usuario) {
        try {
            String mensaje = gestorUsuario.setUsuario(usuario);
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
            String mensaje = gestorUsuario.deleteUsuario(nombre);

            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping("/usuario/{id}")
    public ResponseEntity <ObjetoRespuesta> patchUsuario(@RequestBody Usuario useri, @PathVariable String id) {
        try {
            Usuario user = gestorUsuario.updateUsuario(useri, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

