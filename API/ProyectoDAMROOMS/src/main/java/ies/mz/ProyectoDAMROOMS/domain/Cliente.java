package ies.mz.ProyectoDAMROOMS.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "reservas"})
public class Cliente {
    @Schema(description = "Identificador del cliente", example = "99999999A", required = true)
    @Id
    @Column(name = "dni")
    private String dni;

    @Schema(description = "Nombre del cliente", example = "Lazaro", required = true)
    @Column(name = "nombre")
    private String nombre;

    @Schema(description = "Apellidos del cliente", example = "Ortega Boix", required = true)
    @Column(name = "apellidos")
    private String apellidos;

    @Schema(description = "Direccion del cliente", example = "Calle Castelar n37", required = true)
    @Column(name = "dirección")
    private String direccion;

    @Schema(description = "Telefono del cliente", example = "123456789", required = true)
    @Column(name = "telefono")
    private int telefono;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("reservas")
    private List<Reserva> reservas;
}
