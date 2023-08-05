package com.dh.clinicas.service;



import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Domicilio;
import com.dh.clinicas.persistence.entities.Odontologo;
import com.dh.clinicas.persistence.entities.Paciente;
import com.dh.clinicas.persistence.entities.Turno;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class PacienteServiceTest {
    private static final Logger LOGGER = Logger.getLogger(Odontologo.class.getName());
    @Autowired
    com.dh.clinicas.service.iPacienteService pacienteService;


    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", LocalDate.now(), domicilio));
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", 333, "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardar(new Paciente("Micaela", "Perez", "99999999", LocalDate.now(), domicilio1));

    }
    @Test
    void guardar() {
        LOGGER.info("Iniciando Test guardar  pacientes:");
        this.cargarDataSet();
        Domicilio domicilio = new Domicilio("Calle", 123, "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", LocalDate.now(), domicilio));

        Assert.assertNotNull(pacienteService.buscarPorId(p.getId()));
    }

    @Test
    void buscarTodos() {
        LOGGER.info("Iniciando Test buscar TODOS los pacientes:");

        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 3);
        System.out.println(pacientes);
    }
    @Test
    void buscarPorId() {
        LOGGER.info("Iniciando Test buscar paciente por ID:");

        Paciente pacienteBuscado = pacienteService.buscarPorId(1);
        assertEquals(1, pacienteBuscado.getId());
    }
    @Test
    void eliminar() throws ResourceNotFoundException {
        LOGGER.info("Iniciando Test eliminar paciente por ID:");

        //pacienteService.eliminar(1);
        assertEquals(0, pacienteService.buscarTodos().size());


    }


}