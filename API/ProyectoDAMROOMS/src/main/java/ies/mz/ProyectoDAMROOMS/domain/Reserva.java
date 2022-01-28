package ies.mz.ProyectoDAMROOMS.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoReserva;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date fechaInicio;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date fechaFin;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private float importe;
}
