package ies.mz.ProyectoDAMROOMS.domain;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "Caracteristicas")
    private String caracteristicas;

    @Column(name = "importe_noche")
    private float importe_noche;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Reserva reserva;
}
