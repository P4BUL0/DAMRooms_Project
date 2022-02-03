package ies.mz.ProyectoDAMROOMS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reserva {
    @EmbeddedId
    private ReservaId idReserva = new ReservaId();

    @ManyToOne
    @MapsId("dni")
    private Cliente cliente;

    @ManyToOne
    @MapsId("numero")
    private Habitaciones habitaciones;



    private LocalDate fechaFin;

    private float importeTotal;

}