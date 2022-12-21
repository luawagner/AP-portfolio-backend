/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliowagner.law.Service;

import com.portfoliowagner.law.Entity.Skill;
import com.portfoliowagner.law.Repository.RSkill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class SSkill {
    @Autowired
    RSkill rSkill;
    
    public List<Skill> list(){
        return rSkill.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return rSkill.findById(id);
    }
    
    public Optional<Skill> getByNombre(String nombre){
        return rSkill.findByNombre(nombre);
    }
    
    public void save(Skill skill){
        rSkill.save(skill);
    }
    
    public void delete(int id){
        rSkill.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkill.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rSkill.existsByNombre(nombre);
    }
}
