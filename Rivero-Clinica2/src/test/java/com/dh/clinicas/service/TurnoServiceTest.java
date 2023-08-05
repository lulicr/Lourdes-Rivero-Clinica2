package com.dh.clinicas.service;

import com.dh.clinicas.Exceptions.BadRequestException;
import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Domicilio;
import com.dh.clinicas.persistence.entities.Odontologo;
import com.dh.clinicas.persistence.entities.Paciente;
import com.dh.clinicas.persistence.entities.Turno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {
    private static final Logger LOGGER = Logger.getLogger(Odontologo.class.getName());
    @Autowired
    com.dh.clinicas.service.iTurnoService iTurnoService;
    @Autowired
    com.dh.clinicas.service.iPacienteService iPacienteService;
    @Autowired
    com.dh.clinicas.service.iOdontologoService iOdontologoService;

    @BeforeEach
    public void reset() {

    }



    @Test
    void guardar() throws BadRequestException {
        LOGGER.info("Iniciando Test guardar turno:");

        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Lourdes");
        odontologo.setApellido("Rivero");
        odontologo.setNumeroMatricula("4932");
        iOdontologoService.guardar(odontologo);

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("CalleCreada");
        domicilio.setLocalidad("LocalidadCreada");
        domicilio.setNumero(123);

        Paciente paciente = new Paciente();
        paciente.setNombre("Candelaria");
        paciente.setApellido("Quintan");
        paciente.setDni("4887438");
        paciente.setDomicilios(domicilio);

        iPacienteService.guardar(paciente);

        Turno turn = new Turno(LocalDate.now(), paciente, odontologo);

        Turno turnoGuardado = iTurnoService.guardar(turn);
        Turno turnoBuscado = iTurnoService.buscarPorId(1);

        assertAll(
                () -> assertEquals(turnoGuardado.getId(), turnoBuscado.getId()),
                () -> assertEquals(turnoGuardado.getFecha(), turnoBuscado.getFecha()),
                () -> assertEquals(turnoGuardado.getPaciente().getId(), turnoBuscado.getPaciente().getId()),
                () -> assertEquals(turnoGuardado.getOdontologo().getId(), turnoBuscado.getOdontologo().getId())
        );


    }

    @Test
    void buscarPorId() {
        LOGGER.info("Iniciando Test buscar turno por ID:");

        Turno turnoBuscado = iTurnoService.buscarPorId(1);
        assertEquals(1, turnoBuscado.getId());
    }

    @Test
    void buscarTodos() {
        LOGGER.info("Iniciando Test buscar todos los turnos:");

        assertEquals(1, iTurnoService.buscarTodos().size());
    }
    @Test
    void eliminar() throws ResourceNotFoundException {
        LOGGER.info("Iniciando Test eliminar turno por ID:");

        //iTurnoService.eliminar(1);

        List<Turno> turnos = iTurnoService.buscarTodos();
        assertEquals(0, turnos.size());



    }



}