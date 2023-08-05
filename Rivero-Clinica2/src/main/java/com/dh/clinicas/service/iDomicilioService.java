package com.dh.clinicas.service;

import com.dh.clinicas.persistence.entities.Domicilio;
import com.dh.clinicas.persistence.entities.Odontologo;

import java.util.List;

public interface iDomicilioService {

    Domicilio guardar(Domicilio domicilio);


    Domicilio buscarPorId(Integer id);

    List<Domicilio> buscarTodos();

    Domicilio actualizar(Domicilio domicilio);

    void eliminar(Integer id);

}
