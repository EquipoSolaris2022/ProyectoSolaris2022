package edu.udea.Proyecto_solaris.Controller;

import edu.udea.Proyecto_solaris.Model.Empleado;
import edu.udea.Proyecto_solaris.Model.Empresa;
import edu.udea.Proyecto_solaris.Model.Movimiento_dinero;
import edu.udea.Proyecto_solaris.service.GestorEmpleado;
import edu.udea.Proyecto_solaris.service.GestorEmpresa;
import edu.udea.Proyecto_solaris.service.GestorMovimiento_dinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontEndController {

    GestorEmpresa gestorEmpresa = new GestorEmpresa();
    GestorEmpleado gestorUsuario = new GestorEmpleado();

    @Autowired
    GestorMovimiento_dinero gestormovimiento;

    @GetMapping("/IngMov")
    public String getIngMov(Model model){
        model.addAttribute("formingmov", new Movimiento_dinero());
        return "ingmov";}

    @PostMapping
    public String  IngMov(@ModelAttribute("formingmov") Movimiento_dinero movimiento ){

        try {
            Empresa empresa = gestorEmpresa.getEmpresa(1);
            try {
                Empleado empleado = gestorUsuario.getEmpleado(1111111);
                Movimiento_dinero movimiento_2 = new Movimiento_dinero(movimiento.getMonto(),movimiento.getConcepto(),empleado,empresa);
                System.out.print(movimiento_2);

                //String mensaje = gestormovimiento.setMovimiento(1,movimiento_2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.print(movimiento.getMonto());
        return "redirect:/IngMov";
    }





}
