package com.dh.clinicas.controller;


import com.dh.clinicas.Exceptions.BadRequestException;
import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Odontologo;
import com.dh.clinicas.persistence.entities.Paciente;
import com.dh.clinicas.service.iPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

  @Autowired
  private iPacienteService pacienteService;
  


  @PostMapping("/")
  public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) throws BadRequestException {

    return ResponseEntity.ok(pacienteService.guardar(paciente));
  }



  @GetMapping("/{id}")
  public ResponseEntity<Paciente> buscarPorId(@PathVariable("id") int id) {
    Paciente paciente = pacienteService.buscarPorId(id);
    return ResponseEntity.ok(paciente);
  }


  @PutMapping("/")
  public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
    ResponseEntity<Paciente> response;
    if (paciente.getId() != null && pacienteService.buscarPorId(paciente.getId())!= null){
      response = ResponseEntity.ok(pacienteService.actualizar(paciente));
    } else {
      response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return response;
  }
  @GetMapping("/")
  public ResponseEntity<List<Paciente>> buscarTodos(){
    return ResponseEntity.ok(pacienteService.buscarTodos());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Paciente> eliminar(@PathVariable int id) throws ResourceNotFoundException {
    pacienteService.eliminar(id);
    return ResponseEntity.ok().build();
  }


}
