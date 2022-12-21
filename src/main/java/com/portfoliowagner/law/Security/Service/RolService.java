
package com.portfoliowagner.law.Security.Service;

import com.portfoliowagner.law.Security.Entity.Rol;
import com.portfoliowagner.law.Security.Enums.RolNombre;
import com.portfoliowagner.law.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RolService {
   @Autowired
   iRolRepository irolRepository;
   
   public Optional<Rol> getByRolNombre(RolNombre rolNombre){
       return irolRepository.findByRolNombre(rolNombre);
   }
}
