package ies.mz.ProyectoDAMROOMS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clientes")
public class Cliente {
    @Id
    private String dni;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String apellidos;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String direccion;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int telefono;
}
