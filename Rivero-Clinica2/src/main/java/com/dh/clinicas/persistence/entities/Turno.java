package com.dh.clinicas.persistence.entities;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Turnos")
public class Turno {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private LocalDate fecha;

  @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.MERGE)
  @JoinColumn(name = "pacientes_id", nullable = false)
  private Paciente pacientes;
  @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.MERGE)
  @JoinColumn(name = "odontologos_id", nullable = false)
  private Odontologo odontologos;


  public Turno(Integer id, LocalDate fecha, Paciente paciente, Odontologo odontologo) {
    this.id = id;
    this.fecha = fecha;
    this.pacientes = paciente;
    this.odontologos = odontologo;
  }

  public Turno(LocalDate fecha, Paciente paciente, Odontologo odontologo) {
    this.fecha = fecha;
    this.pacientes = paciente;
    this.odontologos = odontologo;
  }

  public Turno() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public Paciente getPaciente() {
    return pacientes;
  }

  public void setPaciente(Paciente paciente) {
    this.pacientes = paciente;
  }

  public Odontologo getOdontologo() {
    return odontologos;
  }

  public void setOdontologo(Odontologo odontologo) {
    this.odontologos = odontologo;
  }
}
