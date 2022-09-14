package edu.udea.Proyecto_solaris.Repositories;

import edu.udea.Proyecto_solaris.Entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    @Transactional(readOnly = true)
    Optional<Users> findByUsers (String username);

}
