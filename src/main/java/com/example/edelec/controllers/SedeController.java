package com.example.edelec.controllers;


import com.example.edelec.entitys.Carrera;
import com.example.edelec.entitys.Sede;
import com.example.edelec.services.SedeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sede")
public class SedeController {

    private final SedeService sedeService;

    public SedeController(SedeService sedeService) {
        this.sedeService = sedeService;
    }

    @PostMapping
    public ResponseEntity<Sede> createCarrera(@Valid @RequestBody Sede sede) {
        Sede sedeNew = sedeService.createSede(sede);
        return new ResponseEntity<Sede>(sedeNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Sede>> GetAllSedes() {
        List<Sede> sedesNew = sedeService.getAllSedes();
        return new ResponseEntity<List<Sede>>(sedesNew, HttpStatus.OK);
    }

    @GetMapping("/name/{nombreSede}")
    public ResponseEntity<List<Sede>> GetSedesNombre(@PathVariable("nombreSede") String nombreSede) {
        List<Sede> sedesNew = sedeService.getSedesNombre(nombreSede);
        return new ResponseEntity<List<Sede>>(sedesNew, HttpStatus.OK);
    }

    @GetMapping("/{ubicacionSede}")
    public ResponseEntity<List<Sede>> GetSedesUbicacion(@PathVariable("ubicacionSede") String ubicacionSede) {
        List<Sede> sedesNew = sedeService.getSedesUbicacion(ubicacionSede);
        return new ResponseEntity<List<Sede>>(sedesNew, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Sede> updateSede(@Valid @RequestBody Sede sede) {
        Sede sedeUpdate = sedeService.createSede(sede);
        return new ResponseEntity<Sede>(sedeUpdate, HttpStatus.OK);
    }

    @PutMapping("/{idSede}")
    public ResponseEntity<Void> deleteSede(@PathVariable("idSede") Integer idSede) {
        sedeService.deleteSede(idSede);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
