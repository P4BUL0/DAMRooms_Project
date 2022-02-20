package ies.mz.ProyectoDAMROOMS.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva {
    @Schema(description = "Identificador de reserva", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private long idReserva;

    @Schema(description = "Fecha inicio de reserva", example = "2022-01-15", required = true)
    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Schema(description = "Fecha final de reserva", example = "2022-01-25", required = true)
    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Schema(description = "Importe total de reserva", example = "225.99", required = true)
    @Column(name = "importeTotal")
    private float importeTotal;

    @Schema(description = "Estado de reserva", example = "Pendiente", required = true)
    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.DETACH)
    @JoinColumn(name = "clienteDni", nullable = false)
    private Cliente clientes;

    @OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.DETACH)
    @JoinColumn(name = "numeroHabitacion", nullable = false)
    private Habitacion habitacion;

    public void calcImporteTotal(){
        float importeNoche = this.getHabitacion().getImporte_noche();
        long total_dias = DAYS.between(this.fechaInicio, this.fechaFin);

        this.importeTotal = importeNoche * total_dias;
    }
}

