package com.example.edelec.services.impl;
import com.example.edelec.entitys.Carrera;
import com.example.edelec.exception.ResourceNotFoundException;
import com.example.edelec.repositories.CarreraRepository;
import org.springframework.stereotype.Service;
import com.example.edelec.services.CarreraService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarreraServiceImpl implements CarreraService{

    private final CarreraRepository carreraRepository;


    public CarreraServiceImpl(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }



    @Transactional
    public Carrera createCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public List<Carrera> getAllCarrera() {
        return carreraRepository.findAll();
    }

    @Override
    public List<Carrera> getCarreraByName (String name) {
        return carreraRepository.buscarCarreraNombre(name);
    }

    @Override
    public Carrera getCarreraById(Integer idCarrera) {
        return carreraRepository.findById(idCarrera).orElseThrow(()->new ResourceNotFoundException("La carrera no existe: "+idCarrera));
    }

    @Override
    public Carrera updateCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public void deleteCarrera(Integer IdCarrera) {
        carreraRepository.deleteById(IdCarrera);
    }
}
