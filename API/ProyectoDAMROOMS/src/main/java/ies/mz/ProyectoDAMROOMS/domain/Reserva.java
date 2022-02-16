package ies.mz.ProyectoDAMROOMS.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.DETACH)
    @JoinColumn(name = "clienteDni", nullable = false)
    private Cliente clientes;


    @OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.DETACH)
    @JoinColumn(name = "numeroHabitacion", nullable = false)
    private Habitacion habitacion;

    public void calcImporteTotal(){
        float importeNoche = this.getHabitacion().getImporte_noche();
        long total_dias = DAYS.between(this.fechaInicio, this.fechaFin);
        this.importeTotal = importeNoche * total_dias;
    }
}

