package com.portfoliowagner.law.Controller;

import com.portfoliowagner.law.Dto.DtoPersona;
import com.portfoliowagner.law.Entity.Persona;
import com.portfoliowagner.law.Security.Controller.Mensaje;
import com.portfoliowagner.law.Service.ImpPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontend-portfolio-c160d.web.app")
public class CPersona {

    

        @Autowired
        ImpPersonaService personaService;

        @GetMapping("/lista")
        public ResponseEntity<List<Persona>> list() {
            List<Persona> list = personaService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        }

        @GetMapping("/detail/{id}")
        public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
            if (!personaService.existsById(id)) {
                return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
            }

            Persona persona = personaService.getOne(id).get();
            return new ResponseEntity(persona, HttpStatus.OK);
        }

        /*    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoeducacion){
       
        if(personaService.existsByNombreE(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona educacion = new Persona(
                dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE()
            );
        personaService.save(educacion);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
                
    }*/
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtopersona) {
            if (!personaService.existsById(id)) {
                return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
            }
            if (personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
                return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
            }

            Persona persona = personaService.getOne(id).get();

            persona.setNombre(dtopersona.getNombre());
            persona.setApellido(dtopersona.getApellido());
            persona.setDescripcion(dtopersona.getDescripcion());
            persona.setImg(dtopersona.getImg());

            personaService.save(persona);

            return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
        }
        @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtopersona){
       
        if(personaService.existsByNombre(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = new Persona(
                dtopersona.getNombre(),  dtopersona.getApellido(),dtopersona.getDescripcion(),
                dtopersona.getImg()
            );
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
    }
    }
