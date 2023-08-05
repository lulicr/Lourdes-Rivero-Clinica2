package com.dh.clinicas.persistence.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.nio.MappedByteBuffer;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Pacientes")
public class Paciente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private String nombre;
  @Column
  private String apellido;
  @Column
  private String dni;
  @Column
  private LocalDate fechaIngreso;

  @OneToOne( cascade = CascadeType.ALL)
  @JoinColumn(name = "id_domicilio" )

  private Domicilio domicilios;

  @OneToMany(mappedBy = "pacientes", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Set<Turno> turno = new HashSet<>();


  public Paciente(Integer id, String nombre, String apellido, String dni, LocalDate fechaIngreso, Domicilio domicilios) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.fechaIngreso = fechaIngreso;
    this.domicilios = domicilios;
  }

  public Paciente(String nombre, String apellido, String dni, LocalDate fechaIngreso, Domicilio domicilios) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.fechaIngreso = fechaIngreso;
    this.domicilios = domicilios;
  }

  public Paciente() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(LocalDate fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  public Domicilio getDomicilios() {
    return domicilios;
  }

  public void setDomicilios(Domicilio domicilios) {
    this.domicilios = domicilios;
  }

  public Set<Turno> getTurno() {
    return turno;
  }

  public void setTurno(Set<Turno> turno) {
    this.turno = turno;
  }


}
