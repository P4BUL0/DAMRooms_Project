package APIRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {

    private String tipo;
    private String caracteristicas;
    private float importe_noche;

    @Override
    public String toString() {
        return "{" +
                "\"tipo\": \"" + tipo + "\"" +
                ", \"caracteristicas\": \"" + caracteristicas + "\""+
                ", \"importe_noche\": \"" + importe_noche +
                "\"}";
    }
}
