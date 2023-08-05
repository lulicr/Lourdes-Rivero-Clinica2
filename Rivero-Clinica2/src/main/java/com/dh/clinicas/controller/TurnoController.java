package com.dh.clinicas.controller;


import com.dh.clinicas.Exceptions.BadRequestException;
import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Turno;
import com.dh.clinicas.service.iOdontologoService;
import com.dh.clinicas.service.iPacienteService;
import com.dh.clinicas.service.iTurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final iTurnoService turnoService;
    private final iOdontologoService odontologoService;
    private final iPacienteService pacienteService;

    @Autowired
    public TurnoController(iTurnoService turnoService, iOdontologoService odontologoService, iPacienteService pacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }


    @PostMapping("/")
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno) throws BadRequestException {
        // Si el odontologo o paciente no existen, devuelve un error
        /*if (odontologoService.buscarPorId(turno.getOdontologo().getId()) != null && pacienteService.buscarPorId(turno.getPaciente().getId()) != null) {

        } else {
            // Bad request 400
            return ResponseEntity.badRequest().build();
        }*/
        if (odontologoService.buscarPorId(turno.getOdontologo().getId()) != null && pacienteService.buscarPorId(turno.getPaciente().getId()) != null)
        return ResponseEntity.ok(turnoService.guardar(turno));
        throw new BadRequestException("No es posible guardar el turno, paciente u odontologo inexistente");
    }



    @DeleteMapping("/{id}")
  public ResponseEntity<Turno> eliminar(@PathVariable int id) throws ResourceNotFoundException {
      ResponseEntity<Turno> response;
      /*if (turnoService.buscarPorId(id)==null){
          response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      } else {*/
          turnoService.eliminar(id);
          response = ResponseEntity.status(HttpStatus.OK).build();

      return response;
  }

    @GetMapping("/")
    public ResponseEntity<List<Turno>> buscarTodos(){

        return ResponseEntity.ok(turnoService.buscarTodos());
    }

  @PutMapping("/")
  public ResponseEntity<Turno> actualizar(@RequestBody Turno turno){


      ResponseEntity<Turno> response;
      if (pacienteService.buscarPorId(turno.getPaciente().getId()) != null && odontologoService.buscarPorId(turno.getOdontologo().getId()) != null)

      {response = ResponseEntity.ok(turnoService.actualizar(turno));}
      else{
        response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
      return response;

  }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable("id") int id) {
        Turno turno = turnoService.buscarPorId(id);
        return ResponseEntity.ok(turno);
    }
}
