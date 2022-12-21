
package com.portfoliowagner.law.Security.Repository;

import com.portfoliowagner.law.Security.Entity.Rol;
import com.portfoliowagner.law.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
 
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
    
}