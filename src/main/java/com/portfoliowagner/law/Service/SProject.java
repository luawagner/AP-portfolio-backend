
package com.portfoliowagner.law.Service;

import com.portfoliowagner.law.Entity.Project;
import com.portfoliowagner.law.Repository.RProject;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProject {
    @Autowired
    RProject rProject;
    
    public List<Project> list(){
return rProject.findAll();
    }
    
    public Optional<Project> getOne(int id){
        return rProject.findById(id);
    }
    public Optional<Project> getByNombreP(String nombreP){
        return rProject.findByNombreP(nombreP);
    }
    public void save(Project proj){
        rProject.save(proj);
    }
    public void delete(int id){
        rProject.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProject.existsById(id);
    }
    
    public boolean existsByNombreP(String nombreP){
        return rProject.existsByNombreP(nombreP);
    }
}
