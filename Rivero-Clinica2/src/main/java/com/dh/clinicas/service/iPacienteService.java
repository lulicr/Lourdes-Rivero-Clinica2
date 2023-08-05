package com.dh.clinicas.service;

import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Domicilio;
import com.dh.clinicas.persistence.entities.Paciente;

import java.util.List;

public interface iPacienteService {

    Paciente guardar(Paciente paciente);

    void eliminar(Integer id) throws ResourceNotFoundException;

    Paciente buscarPorId(Integer id);

    List<Paciente> buscarTodos();

    Paciente actualizar(Paciente paciente);
}
