package com.example.edelec.services.impl;

import com.example.edelec.entitys.Egresado;
import com.example.edelec.entitys.Sede;
import com.example.edelec.repositories.SedeRepository;
import com.example.edelec.services.SedeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImpl implements SedeService {

    private final SedeRepository sedeRepository;

    public SedeServiceImpl(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    @Override
    public Sede createSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    @Override
    public List<Sede> getAllSedes() {
        return sedeRepository.findAll();
    }

    @Override
    public List<Sede> getSedesNombre(String nombre) {
        return sedeRepository.buscarPorNombre(nombre);
    }

    @Override
    public List<Sede> getSedesUbicacion(String ubicacion) {
        return sedeRepository.buscarPorNombre(ubicacion);
    }

    @Override
    public Sede updateSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    @Override
    public void deleteSede(Integer IdSede) {
        sedeRepository.deleteById(IdSede);
    }
}
