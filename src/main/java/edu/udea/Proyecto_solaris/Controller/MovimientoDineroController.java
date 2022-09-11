package edu.udea.Proyecto_solaris.Controller;


import edu.udea.Proyecto_solaris.Model.Empleado;
import edu.udea.Proyecto_solaris.Model.Empresa;
import edu.udea.Proyecto_solaris.Model.Movimiento_dinero;
import edu.udea.Proyecto_solaris.Model.ObjetoRespuesta;
import edu.udea.Proyecto_solaris.service.GestorMovimientoDinero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MovimientoDineroController {

    GestorMovimientoDinero movimientoDinero = new GestorMovimientoDinero();

    @GetMapping("/enterprises/{id}/movements")
    public ResponseEntity<ArrayList<Movimiento_dinero>> getMovimiento(@PathVariable long id) throws Exception{
        return new ResponseEntity<>(movimientoDinero.getMovimientos(id), HttpStatus.OK);

    }

    @PostMapping("/enterprises/{id}/movements")
    public ResponseEntity<ArrayList<Movimiento_dinero>> postMovimiento(@PathVariable long id,@RequestBody Movimiento_dinero movimiento) throws Exception{


            ArrayList mensaje = movimientoDinero.postMovimiento(id,movimiento);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);

    }

    @PatchMapping("/enterprises/{id}/movements/{id_movimiento}")
    public ResponseEntity <ObjetoRespuesta> patchMovimiento(@RequestBody Movimiento_dinero movimiento, @PathVariable long id_movimiento) {
        try {
            Movimiento_dinero movements = movimientoDinero.updateMovimiento(movimiento, id_movimiento);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", movements), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/enterprises/{id}/movements/{id_movimiento}")
    public ResponseEntity <ObjetoRespuesta> deleteMovimiento(@PathVariable long id_movimiento){
        try {
            String mensaje = movimientoDinero.deleteMovimiento(id_movimiento);

            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
