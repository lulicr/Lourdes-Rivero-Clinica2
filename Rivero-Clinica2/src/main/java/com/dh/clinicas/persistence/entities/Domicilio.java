package com.dh.clinicas.persistence.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Domicilios")
public class Domicilio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column (name = "Calle")
  private String calle;
  @Column (name = "Nro")
  private int numero;
  @Column (name = "Localidad")
  private String localidad;
  @Column(name = "Prov")
  private String provincia;



  public Domicilio(Integer id, String calle, int numero, String localidad, String provincia, Set<Paciente> paciente) {
    this.id = id;
    this.calle = calle;
    this.numero = numero;
    this.localidad = localidad;
    this.provincia = provincia;

  }

  public Domicilio(String calle, int numero, String localidad, String provincia, Set<Paciente> paciente) {
    this.calle = calle;
    this.numero = numero;
    this.localidad = localidad;
    this.provincia = provincia;

  }

  public Domicilio(String calle, int numero, String localidad, String provincia) {
    this.calle = calle;
    this.numero = numero;
    this.localidad = localidad;
    this.provincia = provincia;
  }

  public Domicilio() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getLocalidad() {
    return localidad;
  }

  public void setLocalidad(String localidad) {
    this.localidad = localidad;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }


}
