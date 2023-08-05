package com.dh.clinicas.service;


import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Odontologo;
import com.dh.clinicas.persistence.entities.Paciente;
import com.dh.clinicas.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements iPacienteService{

  @Autowired
  IPacienteRepository iPacienteRepository;

  @Override
  public Paciente guardar(Paciente paciente) {
    return iPacienteRepository.save(paciente);
  }

  @Override
  public void eliminar(Integer id) throws ResourceNotFoundException {
    if (buscarPorId(id) == null)
      throw new ResourceNotFoundException("No existe un paciente con el id:" +id);
   iPacienteRepository.delete(buscarPorId(id));
  }

  @Override
  public Paciente buscarPorId(Integer id) {
    return iPacienteRepository.findById(id).orElse(null);
  }

  @Override
  public List<Paciente> buscarTodos() {
    return iPacienteRepository.findAll();
  }

  @Override
  public Paciente actualizar(Paciente paciente) {
    return iPacienteRepository.save(paciente);
  }
}
