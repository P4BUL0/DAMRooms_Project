package APIRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * @author Pablo, Boix y Lazaro
 * @version 1.0
 * @since 2022-02-22
 */
public class Habitacion {

    private long numero;
    private String tipo;
    private String caracteristicas;
    private float importe_noche;

    /**
     *
     * @return Devuelve un String del objeto con formato de json
     */
    @Override
    public String toString() {
        return "{" +
                " \"numero\": \"" + numero + "\"" +
                ", \"tipo\": \"" + tipo + "\"" +
                ", \"caracteristicas\": \"" + caracteristicas + "\"" +
                ", \"importe_noche\": \"" + importe_noche +
                "\"}";
    }
}
