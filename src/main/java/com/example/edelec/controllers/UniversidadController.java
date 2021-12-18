package com.example.edelec.controllers;

import com.example.edelec.entitys.Sede;
import com.example.edelec.entitys.Universidad;
import com.example.edelec.services.UniversidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/universidades")
public class UniversidadController {

    private final UniversidadService universidadService;

    public UniversidadController(UniversidadService universidadService) {
        this.universidadService = universidadService;
    }

    @PostMapping
    public ResponseEntity<Universidad> createUniversidad(@Valid @RequestBody Universidad universidad) {
        Universidad universidadNew =universidadService.createUniversidad(universidad);
        return  new ResponseEntity<Universidad>(universidadNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Universidad>> GetAllUniversidades() {
        List<Universidad> universidades = universidadService.getAllUniversidad();
        return  new ResponseEntity<List<Universidad>>(universidades, HttpStatus.OK);
    }

    @GetMapping("/{nombreUniversidad}")
    public ResponseEntity<List<Universidad>> GetUniversidadByNombre(@PathVariable("nombreUniversidad") String nombreUniversidad) {
        List<Universidad> universidades = universidadService.getUniversidadByname(nombreUniversidad);
        return  new ResponseEntity<List<Universidad>>(universidades, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Universidad> updateSede(@Valid @RequestBody Universidad universidad){
        Universidad universidadNew = universidadService.updateUniversidad(universidad);
        return  new ResponseEntity<Universidad>(universidadNew, HttpStatus.OK);
    }

    @PutMapping("/{idUniversidad}")
    public ResponseEntity<Void> deleteSede(@PathVariable("idUniversidad") Integer idUniversidad){
        universidadService.deleteUniversidadById(idUniversidad);
        return  new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
