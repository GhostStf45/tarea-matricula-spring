package com.contoso.demo.controller;

import com.contoso.demo.model.Alumno;
import com.contoso.demo.repository.AlumnoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/alumno", produces = "application/json")
public class AlumnoController {
    private final AlumnoRepository alumnoData;
    public AlumnoController(AlumnoRepository alumnoData){
        this.alumnoData = alumnoData;

    }
    // Crear alumno 
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Alumno a){

        alumnoData.save(a);
        alumnoData.flush();

        return new ResponseEntity<Integer>(a.getId(), HttpStatus.CREATED);

    }
     // obtener una factura
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Alumno> findByNumber(@PathVariable Integer id)
    {
        Optional<Alumno> optionAlumno = alumnoData.findByCodigo(id);
        if(optionAlumno.isPresent()) {
            Alumno alumno = optionAlumno.get();
            return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
        }else{
            return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }

     }
}
