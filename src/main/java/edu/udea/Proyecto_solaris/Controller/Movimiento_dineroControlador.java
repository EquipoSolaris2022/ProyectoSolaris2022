package edu.udea.Proyecto_solaris.Controller;

import edu.udea.Proyecto_solaris.Model.Movimiento_dinero;
import edu.udea.Proyecto_solaris.service.GestorMovimiento_dinero;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.web.bind.annotation.*;
import edu.udea.Proyecto_solaris.Model.ObjetoRespuesta;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Movimiento_dineroControlador {
    GestorMovimiento_dinero gestormovimiento = new GestorMovimiento_dinero();

    @GetMapping("/enterprises/{id}/movements")
    public ResponseEntity<List<Movimiento_dinero>> getMovimientos(@PathVariable long id) throws Exception{
        return new ResponseEntity<>(gestormovimiento.getMovimientos(id), HttpStatus.OK);
    }

    @PostMapping("/enterprises/{id}/movements")
    public ResponseEntity<ArrayList> postMovimiento(@PathVariable long id, @RequestBody Movimiento_dinero moviparam) throws Exception {
        ArrayList mensaje = gestormovimiento.setMovimiento(id, moviparam);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PatchMapping("/enterprises/{id}/movements/{idmov}")
    public ResponseEntity <ObjetoRespuesta> patchMovimiento(@RequestBody Movimiento_dinero moviparam, @PathVariable long idmov) {
        try {
            Movimiento_dinero movi = gestormovimiento.updateMovimiento(moviparam, idmov);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", movi), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/enterprises/{id}/movements/{id_movimiento}")
    public ResponseEntity <ObjetoRespuesta> deleteMovimiento(@PathVariable long id){
        try {
            String mensaje = gestormovimiento.deleteMovimiento(id);

            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
