package ies.mz.ProyectoDAMROOMS.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tipo;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String caracteristicas;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private float importe_noche;
}
