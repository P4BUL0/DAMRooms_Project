package ies.mz.ProyectoDAMROOMS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clientes")
public class Cliente {
    @Id
    private String dni;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private String direccion;
    @Column
    private int telefono;
}
