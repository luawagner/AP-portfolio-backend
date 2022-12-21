/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliowagner.law.Repository;

import com.portfoliowagner.law.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface RSkill extends JpaRepository<Skill, Integer>{
    Optional<Skill> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
