package com.dh.clinicas.service;

import com.dh.clinicas.Exceptions.BadRequestException;
import com.dh.clinicas.Exceptions.ResourceNotFoundException;
import com.dh.clinicas.persistence.entities.Odontologo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import java.util.logging.Logger;
@SpringBootTest
class OdontologoServiceTest {
    private static final Logger LOGGER = Logger.getLogger(Odontologo.class.getName());


        @Autowired
        com.dh.clinicas.service.iOdontologoService iOdontologoService;

        @Test
        void guardar() throws BadRequestException {

            LOGGER.info("Iniciando Test guardar odontologos:");

            Odontologo odontologo = new Odontologo();
            odontologo.setNombre("Lourdes");
            odontologo.setApellido("Rivero");
            odontologo.setNumeroMatricula("4932");
            iOdontologoService.guardar(odontologo);
            Odontologo odontologoLourdes =iOdontologoService.buscarPorId(1);
            assertTrue(odontologoLourdes != null);
        }

        @Test
        void buscarPorId() {
            LOGGER.info("Iniciando Test buscar por ID odontologos:");

            Odontologo odontologoBuscado = iOdontologoService.buscarPorId(1);
            //Odontologo odontologoNull = iOdontologoService.buscarPorId(5);

            assertAll(
                    () -> assertEquals(1, odontologoBuscado.getId()),
                    () -> assertEquals("4932", odontologoBuscado.getNumeroMatricula()),
                    () -> assertEquals("Lourdes", odontologoBuscado.getNombre()),
                    () -> assertEquals("Rivero", odontologoBuscado.getApellido())

            );
            //assertNull(odontologoNull);

        }
        @Test
        void buscarTodos() {
            LOGGER.info("Iniciando Test buscar TODOS los odontologos:");

        List<Odontologo> odontologos = iOdontologoService.buscarTodos();
        assertEquals(1,odontologos.size());
       }
       @Test
        void eliminar() throws ResourceNotFoundException {
           LOGGER.info("Iniciando Test eliminar odontologo por ID:");

        //iOdontologoService.eliminar(1);

        List<Odontologo> odontologos = iOdontologoService.buscarTodos();
        assertEquals(0, odontologos.size());
    }

}