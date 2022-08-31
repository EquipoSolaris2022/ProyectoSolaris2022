package edu.udea.Proyecto_solaris.Controller;

import edu.udea.Proyecto_solaris.Model.Movimiento_dinero;
import edu.udea.Proyecto_solaris.service.GestorMovimiento_dinero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.udea.Proyecto_solaris.Model.ObjetoRespuesta;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class Movimiento_dineroControlador {
    GestorMovimiento_dinero gestormovimiento = new GestorMovimiento_dinero();

    @GetMapping("/empresa/{consecutivo}")
    public ResponseEntity<List<Movimiento_dinero>> getMovimientos(){
        return new ResponseEntity<>(gestormovimiento.getMovimientos(), HttpStatus.OK);
    }

    @GetMapping("/empresa/{consecutivo}")
    public ResponseEntity<Object> getMovimiento(@RequestParam int consecutivo){
        try{
            Movimiento_dinero movimi=gestormovimiento.getMovimiento(consecutivo);
            return new ResponseEntity<>(movimi, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/empresa/{consecutivo}")
    public ResponseEntity<String> postMovimiento(@RequestBody Movimiento_dinero moviparam) {
        try {
            String mensaje = gestormovimiento.setMovimiento(moviparam);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/empresa/{consecutivo}")
    public ResponseEntity <ObjetoRespuesta> putMovimiento(@RequestBody Movimiento_dinero moviparam, @PathVariable int consecutivo) {
        try {
            Movimiento_dinero movi = gestormovimiento.updateMovimientoAll(moviparam, consecutivo);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", movi), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/empresa/{consecutivo}")
    public ResponseEntity <ObjetoRespuesta> patchMovimiento(@RequestBody Movimiento_dinero moviparam, @PathVariable int consecutivo) {
        try {
            Movimiento_dinero movi = gestormovimiento.updateMovimiento(moviparam, consecutivo);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", movi), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/empresa/{consecutivo}")
    public ResponseEntity <ObjetoRespuesta> deleteMovimiento(@PathVariable int consecutivo){
        try {
            String mensaje = gestormovimiento.deleteMovimiento(consecutivo);

            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
