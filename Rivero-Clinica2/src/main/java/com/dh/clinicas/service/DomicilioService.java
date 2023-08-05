package com.dh.clinicas.service;

import com.dh.clinicas.persistence.entities.Domicilio;
import com.dh.clinicas.repository.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DomicilioService implements iDomicilioService{

    @Autowired
    IDomicilioRepository domicilioRepository;

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Domicilio buscarPorId(Integer id) {
        return domicilioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return domicilioRepository.findAll();
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminar(Integer id) {
        domicilioRepository.deleteById(id);
    }
}
