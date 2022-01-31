package ies.mz.ProyectoDAMROOMS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private int idReserva;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Column(name = "fechaFin")
    private Date fechaFin;

    @Column(name = "importeTotal")
    private float importeTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @ManyToMany(fetch = FetchType.LAZY)
    private Habitacion habitacion;
}
