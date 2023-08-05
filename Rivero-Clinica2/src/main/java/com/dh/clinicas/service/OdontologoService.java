package com.dh.clinicas.service;


import com.dh.clinicas.Exceptions.BadRequestException;
import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Domicilio;
import com.dh.clinicas.persistence.entities.Odontologo;
import com.dh.clinicas.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements iOdontologoService{


  @Autowired
  IOdontologoRepository iOdontologoRepository;

  public OdontologoService(IOdontologoRepository odontologoRepository) {
  }


  @Override
  public Odontologo guardar(Odontologo odontologo)throws BadRequestException {

    return iOdontologoRepository.save(odontologo);
  }



  @Override
  public Odontologo buscarPorId(Integer id) {
    return iOdontologoRepository.findById(id).orElse(null);
  }

  @Override
  public List<Odontologo> buscarTodos() {
    return iOdontologoRepository.findAll();
  }

  @Override
  public Odontologo actualizar(Odontologo odontologo) {
    return iOdontologoRepository.save(odontologo);
  }

  @Override
  public void eliminar(Integer id) throws ResourceNotFoundException {
    if (buscarPorId(id) == null)
      throw new ResourceNotFoundException("No existe un odontologo con el id:" +id);

      iOdontologoRepository.delete(buscarPorId(id));
  }
}
