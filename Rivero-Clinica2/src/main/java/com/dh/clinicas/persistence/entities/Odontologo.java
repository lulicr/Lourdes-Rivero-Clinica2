package com.dh.clinicas.persistence.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Odontologos")
public class Odontologo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "NroMatricula")
  private String numeroMatricula;
  @Column(name = "Nombre")
  private String nombre;
  @Column(name = "Apellido")
  private String apellido;
  @OneToMany(mappedBy = "odontologos", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Set<Turno> turno = new HashSet<>();

  public Odontologo(Integer id, String numeroMatricula, String nombre, String apellido) {
    this.id = id;
    this.numeroMatricula = numeroMatricula;
    this.nombre = nombre;
    this.apellido = apellido;
  }

  public Odontologo(String numeroMatricula, String nombre, String apellido) {
    this.numeroMatricula = numeroMatricula;
    this.nombre = nombre;
    this.apellido = apellido;
  }

  public Odontologo() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNumeroMatricula() {
    return numeroMatricula;
  }

  public void setNumeroMatricula(String numeroMatricula) {
    this.numeroMatricula = numeroMatricula;
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


}
