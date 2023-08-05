package com.dh.clinicas.repository;

import com.dh.clinicas.persistence.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
