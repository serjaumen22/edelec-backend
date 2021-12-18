package com.example.edelec.services.impl;


import com.example.edelec.entitys.Egresado;
import com.example.edelec.repositories.EgresadoRepository;
import com.example.edelec.services.EgresadoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EgresadoServiceImpl implements EgresadoService {

    private final EgresadoRepository egresadoRepository;

    public EgresadoServiceImpl(EgresadoRepository egresadoRepository) {
        this.egresadoRepository = egresadoRepository;
    }

    @Override
    public Egresado createEgresado(Egresado egresado) {
        return egresadoRepository.save(egresado);
    }

    @Override
    public List<Egresado> getAllEgresado() {
        return egresadoRepository.findAll();
    }

    //@Override
    //public List<Egresado> getEgresadoUniversidadCarrera(String nameUniversidad, String nameCarrera) {
    //    return egresadoRepository.buscarPornombreCarrera(nameCarrera, nameUniversidad);
    //}

    @Override
    public Egresado updateEgresado(Egresado egresado) {
        return egresadoRepository.save(egresado);
    }

    @Override
    public void deleteEgresado(Integer idEgresado) {
        egresadoRepository.deleteById(idEgresado);
    }
}
