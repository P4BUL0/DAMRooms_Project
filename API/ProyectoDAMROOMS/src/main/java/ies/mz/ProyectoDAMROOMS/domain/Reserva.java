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
@Table(name = "reserva",uniqueConstraints=@UniqueConstraint(columnNames= {"numero","dni"}))
public class Reserva {
    @Id
    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private long idReserva;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "importeTotal")
    private float importeTotal;

    @Column(name="numero")
    private long numero;

    @Column(name="dni")
    private String dni;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Cliente> clientes = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Habitacion> habitaciones = new ArrayList<>();

}
