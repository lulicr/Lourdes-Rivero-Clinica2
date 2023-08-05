package com.dh.clinicas.repository;


import com.dh.clinicas.persistence.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
}
