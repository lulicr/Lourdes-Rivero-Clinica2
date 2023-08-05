package com.dh.clinicas.repository;

import com.dh.clinicas.persistence.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDomicilioRepository extends JpaRepository<Domicilio, Integer> {
}
