package ies.mz.ProyectoDAMROOMS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReservaId implements Serializable {


    private static final long serialVersionUID = 1L;

    private String dni;

    private long numero;

    private LocalDate fechaInicio;


}
