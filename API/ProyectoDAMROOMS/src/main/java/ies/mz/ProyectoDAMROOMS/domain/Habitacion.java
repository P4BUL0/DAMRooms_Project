package ies.mz.ProyectoDAMROOMS.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "habitaciones")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "reservas"})
public class Habitacion {
    @Schema(description = "Identificador de habitacion", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numero;

    @Schema(description = "Tipo de habitacion", example = "", required = true)
    @Column(name = "tipo")
    private String tipo;

    @Schema(description = "Caracteristicas de habitacion", example = "", required = true)
    @Column(name = "caracteristicas")
    private String caracteristicas;

    @Schema(description = "Importe por noche de habitacion", example = "25.55", required = true)
    @Column(name = "importe_noche")
    private float importe_noche;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("reservas")
    private Reserva reservas;

    /*public Habitacion(long numero, String tipo, String caracteristicas, float importe_noche) {
        this.numero = numero;
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.importe_noche = importe_noche;
    }*/
}
