package edu.udea.Proyecto_solaris.Repositorio;

import edu.udea.Proyecto_solaris.Model.Movimiento_dinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Movimiento_dineroRepositorio extends JpaRepository<Movimiento_dinero,Long>{
        //pendiente por aplicar al proyecto
        List<Movimiento_dinero> findAllByempresa(long id);
}
