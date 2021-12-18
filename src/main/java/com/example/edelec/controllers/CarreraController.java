package com.example.edelec.controllers;


import com.example.edelec.entitys.Carrera;
import com.example.edelec.services.CarreraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/carrera")

public class CarreraController {

    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @PostMapping
    public ResponseEntity<Carrera> createCarrera(@Valid @RequestBody Carrera carrera) {
       Carrera carreraNew =carreraService.createCarrera(carrera);
        return  new ResponseEntity<Carrera>(carreraNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Carrera>> getAllCarrera() {
        List<Carrera> carreras =carreraService.getAllCarrera();
        return new ResponseEntity<List<Carrera>>(carreras, HttpStatus.OK);
    }

    @GetMapping("/{carreraId}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable("carreraId") Integer IdCarrera) {
        Carrera carrera =carreraService.getCarreraById(IdCarrera);
        return new ResponseEntity<Carrera>(carrera, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nameCarrera}")
    public ResponseEntity<List<Carrera>> getCarreraByName(@PathVariable("nameCarrera") String nameCarrera) {
        List<Carrera> carrera =carreraService.getCarreraByName(nameCarrera);
        return new ResponseEntity<List<Carrera>>(carrera, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Carrera> updateCarrera(@RequestBody Carrera carrera) {
        Carrera carreraActulizar =carreraService.updateCarrera(carrera);
        return new ResponseEntity<Carrera>(carreraActulizar, HttpStatus.OK);
    }

    @DeleteMapping("/{carreraId}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable("carreraId") Integer IdCarrera) {
        carreraService.deleteCarrera(IdCarrera);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
