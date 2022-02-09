package ies.mz.ProyectoDAMROOMS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private long idReserva;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "importeTotal")
    private float importeTotal;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteDni", nullable = false)
    /*@JoinTable(name = "reserva_cliente",
            joinColumns = {@JoinColumn(name = "idReserva")},
            inverseJoinColumns = {@JoinColumn(name = "dniCLiente")})*/
    private Cliente clientes;

    @OneToOne
    @JoinColumn(name = "numeroHabitacion", nullable = false)
    /*@JoinTable(name = "reserva_habitaciones",
            joinColumns = {@JoinColumn(name = "idReserva")},
            inverseJoinColumns = {@JoinColumn(name = "numeroHabitacion")})*/
    private Habitaciones habitaciones;

    public void calcImporteTotal(float importeNoche){
        long total_dias = DAYS.between(this.fechaInicio, this.fechaFin);

        /*Period period = Period.between(this.fechaInicio, this.fechaFin);
        int diferencia_anyos = period.getYears() * 360;
        int diferencia_meses = period.getMonths() * 12;
        int diferencia_dias = period.getDays();
        int total_dias = diferencia_anyos + diferencia_meses + diferencia_dias;*/
        this.importeTotal = importeNoche * total_dias;
    }
}

