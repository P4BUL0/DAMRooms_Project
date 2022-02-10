package ies.mz.ProyectoDAMROOMS.domain;

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
@Table(name = "clientes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "reservas"})

public class Cliente {
    @Id
    @Column(name = "dni")
    private String dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "dirección")
    private String direccion;

    @Column(name = "telefono")
    private int telefono;

    @OneToMany(mappedBy = "clientes",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("reservas")
    private List<Reserva> reservas;
}
