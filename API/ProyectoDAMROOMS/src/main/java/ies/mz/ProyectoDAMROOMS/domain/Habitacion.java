package ies.mz.ProyectoDAMROOMS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numero;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "caracteristicas")
    private String caracteristicas;

    @Column(name = "importe_noche")
    private float importe_noche;

    @ManyToMany(cascade =  CascadeType.DETACH)
    @JoinTable(name = "habitacion_reserva",
            joinColumns = { @JoinColumn(name = "numero") },
            inverseJoinColumns = { @JoinColumn(name = "dni") })
    private List<Reserva> reserva;
}
