package com.dh.clinicas.repository;

import com.dh.clinicas.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

    }
