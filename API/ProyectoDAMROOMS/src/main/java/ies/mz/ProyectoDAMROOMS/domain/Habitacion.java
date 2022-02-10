package ies.mz.ProyectoDAMROOMS.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "reservas"})
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

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("reservas")
    private Reserva reservas;
}
