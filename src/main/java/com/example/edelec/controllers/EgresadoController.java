package com.example.edelec.controllers;


import com.example.edelec.entitys.Egresado;
import com.example.edelec.entitys.Sede;
import com.example.edelec.services.EgresadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/egresado")
public class EgresadoController {

    private final EgresadoService egresadoService;

    public EgresadoController(EgresadoService egresadoService) {
        this.egresadoService = egresadoService;
    }
    
    @PostMapping
    public ResponseEntity<Egresado> createEgresado(@Valid @RequestBody Egresado egresado) {
        Egresado egresadoNew =egresadoService.createEgresado(egresado);
        return  new ResponseEntity<Egresado>(egresadoNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Egresado>> GetAllEgresados() {
        List<Egresado> egresados =egresadoService.getAllEgresado();
        return  new ResponseEntity<List<Egresado>>(egresados, HttpStatus.OK);
    }

    //@GetMapping("/busca_universidad_carrera/{nombreUniversidad}/{nombreCarrera}")
    //public ResponseEntity<List<Egresado>> GetEgresadoByUniversdidadCarrera(@PathVariable("nombreUniversidad") String nombreUniversidad, @PathVariable("nombreCarrera") String nombreCarrera) {
    //    List<Egresado> egresados =egresadoService.getEgresadoUniversidadCarrera(nombreUniversidad, nombreCarrera);
    //    return  new ResponseEntity<List<Egresado>>(egresados, HttpStatus.OK);
    //}

    @PutMapping
    public ResponseEntity<Egresado> updateEgresado(@Valid @RequestBody Egresado egresado){
        Egresado egresadoUpdated =egresadoService.updateEgresado(egresado);
        return  new ResponseEntity<Egresado>(egresadoUpdated, HttpStatus.OK);
    }

    @PutMapping("/{idEgresado}")
    public ResponseEntity<Void> deleteEgresado(@PathVariable("idEgresado") Integer idEgresado){
        egresadoService.deleteEgresado(idEgresado);
        return  new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
