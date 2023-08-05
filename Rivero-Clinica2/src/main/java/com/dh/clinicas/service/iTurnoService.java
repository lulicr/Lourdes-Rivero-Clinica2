package com.dh.clinicas.service;


import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Turno;

import java.util.List;

public interface iTurnoService {

     Turno guardar(Turno turno);
     Turno buscarPorId(Integer id);

     List<Turno> buscarTodos();

     Turno actualizar(Turno turno);
     void eliminar(Integer id) throws ResourceNotFoundException;
}
