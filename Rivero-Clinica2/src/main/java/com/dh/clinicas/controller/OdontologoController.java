package com.dh.clinicas.controller;


import com.dh.clinicas.Exceptions.BadRequestException;
import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Odontologo;
import com.dh.clinicas.service.iOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/odontologos")

public class OdontologoController {
    @Autowired
    iOdontologoService odontologoService;

    @PostMapping("/")
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) throws BadRequestException {
        return ResponseEntity.ok(odontologoService.guardar(odontologo));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable("id") int id) {
        Odontologo odontologo = odontologoService.buscarPorId(id);
        return ResponseEntity.ok(odontologo);
    }

    @PutMapping("/")
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response;
        if (odontologo.getId() != null && odontologoService.buscarPorId(odontologo.getId())!= null){
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }


    @GetMapping("/")
    public ResponseEntity<List<Odontologo>> buscarTodos(){

        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Odontologo> eliminar(@PathVariable int id) throws ResourceNotFoundException {

        odontologoService.eliminar(id);
        return ResponseEntity.ok().build();
    }



}
