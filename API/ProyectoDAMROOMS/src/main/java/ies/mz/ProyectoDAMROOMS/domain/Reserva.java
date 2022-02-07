package ies.mz.ProyectoDAMROOMS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reserva {
    @EmbeddedId
    private ReservaId idReserva = new ReservaId();;

    @ManyToOne
    @MapsId("dni")
    private Cliente cliente;

    @ManyToOne
    @MapsId("numero")
    private Habitaciones habitaciones;

    private LocalDate fechaFin;

    private float importeTotal;

    public void calcImporteTotal(float importeNoche){
        Period period = Period.between(idReserva.getFechaInicio(), this.fechaFin);
        int diferencia_anyos = period.getYears() * 360;
        int diferencia_meses = period.getMonths() * 12;
        int diferencia_dias = period.getDays();
        int total_dias = diferencia_anyos + diferencia_meses + diferencia_dias;
        this.importeTotal = importeNoche * total_dias;
    }

    //private String estado = "Pendiente";
}

