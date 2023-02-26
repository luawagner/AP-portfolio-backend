
package com.portfoliowagner.law.Repository;

import com.portfoliowagner.law.Entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProject extends JpaRepository<Project, Integer> {
    public Optional<Project> findByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP);
}
