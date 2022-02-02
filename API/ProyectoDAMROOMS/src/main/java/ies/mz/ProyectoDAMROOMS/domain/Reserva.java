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

    @ManyToMany
    @MapsId("numero")
    private Habitacion habitacion;

    @ManyToMany
    @MapsId("dni")
    private Cliente cliente;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "importeTotal")
    private float importeTotal;

}
