package ies.mz.ProyectoDAMROOMS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
public class Reserva {
    @EmbeddedId
    private ReservaId idReserva;

    @ManyToOne
    @MapsId("dni")
    private Cliente cliente;

    @ManyToOne
    @MapsId("numero")
    private Habitaciones habitaciones;

    private LocalDate fechaFin;

    private float importeTotal;

    private estado estado;

    public Reserva(){
        idReserva = new ReservaId();
        this.estado = ies.mz.ProyectoDAMROOMS.domain.estado.PENDIENTE;
    }
}

enum estado {
    PENDIENTE,
    LIBRE,
    EN_ACTIVO
}