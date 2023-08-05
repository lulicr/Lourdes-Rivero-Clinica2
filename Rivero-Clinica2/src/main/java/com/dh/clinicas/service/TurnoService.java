package com.dh.clinicas.service;

import com.dh.clinicas.Exceptions.BadRequestException;
import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Turno;
import com.dh.clinicas.repository.ITurnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TurnoService implements iTurnoService{


  @Autowired
  ITurnoRepository iTurnoRepository;
  @Autowired
  OdontologoService odontologoService;
  PacienteService pacienteService;

  @Override
  public Turno guardar(Turno turno) {

    return iTurnoRepository.save(turno);
  }

  @Override
  public Turno actualizar(Turno turno) {
    return iTurnoRepository.save(turno);
  }


  @Override
  public Turno buscarPorId(Integer id) {
    return iTurnoRepository.findById(id).orElse(null);
  }

  @Override
  public List<Turno> buscarTodos() {
    return iTurnoRepository.findAll();
  }


  @Override
  public void eliminar(Integer id) throws ResourceNotFoundException{
    if (buscarPorId(id) == null)
      throw new ResourceNotFoundException("No existe un turno con el id:" +id);

    iTurnoRepository.delete(buscarPorId(id));
  }

}
