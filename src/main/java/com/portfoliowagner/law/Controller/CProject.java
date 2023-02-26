package com.portfoliowagner.law.Controller;

import com.portfoliowagner.law.Dto.DtoProject;
import com.portfoliowagner.law.Entity.Project;
import com.portfoliowagner.law.Security.Controller.Mensaje;
import com.portfoliowagner.law.Service.SProject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = {"https://frontend-portfolio-c160d.web.app", "http://localhost:4200"})
public class CProject {

    @Autowired
    SProject sProject;

    @GetMapping("/lista")
    public ResponseEntity<List<Project>> list(){
        List<Project> list = sProject.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")

    public ResponseEntity<Project> getById(@PathVariable("id") int id) {

        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        Project project = sProject.getOne(id).get();

        return new ResponseEntity(project, HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        sProject.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProject dtoPro) {
       if ((dtoPro.getNombreP()).isBlank()) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

         Project project = new Project(dtoPro.getNombreP(), dtoPro.getDescriptionP(),  dtoPro.getImgP(), dtoPro.getUrlP(),dtoPro.getGithubP());
        sProject.save(project);

        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProject dtoPro) {
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        Project project = sProject.getOne(id).get();
        project.setNombreP(dtoPro.getNombreP());
        project.setDescriptionP(dtoPro.getDescriptionP());
        project.setImgP(dtoPro.getImgP());
        project.setUrlP(dtoPro.getUrlP());
        project.setGithubP(dtoPro.getGithubP());

        sProject.save(project);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    }

    

}
