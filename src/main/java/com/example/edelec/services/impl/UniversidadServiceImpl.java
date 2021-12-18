package com.example.edelec.services.impl;

import com.example.edelec.entitys.Universidad;
import com.example.edelec.repositories.UniversidadRepository;
import com.example.edelec.services.UniversidadService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UniversidadServiceImpl implements UniversidadService {

    private final UniversidadRepository universidadRepository;

    public UniversidadServiceImpl(UniversidadRepository universidadRepository) {
        this.universidadRepository = universidadRepository;
    }
    @Transactional
    public Universidad createUniversidad(Universidad universidad){
        return universidadRepository.save(universidad);
    }

    @Override
    public List<Universidad> getAllUniversidad() {
        return universidadRepository.findAll();
    }

    @Override
    public List<Universidad> getUniversidadByname(String name){
        return  universidadRepository.buscarUniversidad(name);
    }


    @Override
    public Universidad updateUniversidad(Universidad universidad){
        return universidadRepository.save(universidad);
    }

    @Override
    public void deleteUniversidad(String name){
        Integer id= universidadRepository.buscarUniversidadByName(name).getIdUniversidad();
        universidadRepository.deleteById(id);
    }

    @Override
    public void deleteUniversidadById(Integer idUniversidad) {
        universidadRepository.deleteById(idUniversidad);
    }
}
