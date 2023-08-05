package com.dh.clinicas.service;



import com.dh.clinicas.Exceptions.BadRequestException;
import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Odontologo;


import java.util.List;

public interface iOdontologoService {
    Odontologo guardar(Odontologo odontologo) throws BadRequestException;


    Odontologo buscarPorId(Integer id);

    List<Odontologo> buscarTodos();

    Odontologo actualizar(Odontologo odontologo);

    void eliminar(Integer id) throws ResourceNotFoundException;
}
