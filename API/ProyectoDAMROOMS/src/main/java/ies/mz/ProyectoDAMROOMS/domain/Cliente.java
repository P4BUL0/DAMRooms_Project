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
@Table(name = "clientes")
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

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    private List<Reserva> reservas;
}
