package edu.udea.Proyecto_solaris.Repositorio;

import edu.udea.Proyecto_solaris.Model.Movimiento_dinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Movimiento_dineroRepositorio extends JpaRepository<Movimiento_dinero,Long>{
        //pendiente por aplicar al proyecto
        @Modifying
        @Query("UPDATE Usuario u SET u.nombre= :nombre, u.password= :password WHERE u.nombreUsuario= :id")
        public int update(String nombre, String password, String id);
}
