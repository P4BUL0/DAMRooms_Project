package APIRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * @author Pablo, Boix y Lazaro
 * @version 1.0
 * @since 2022-02-22
 */
public class Reserva {

    private long idReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float importeTotal;
    private Cliente cliente;
    private Habitacion habitacion;

    /**
     *
     * @return Devuelve un String del objeto con formato de json
     */
    @Override
    public String toString(){
        return "{" +
                "\"fechaInicio\": \"" + fechaInicio + "\"" +
                ", \"fechaFin\": \"" + fechaFin + "\"" +
                ", \"importeTotal\": \"" + importeTotal + "\"" +
                ", \"cliente\": {\"dni\":\"" + cliente.getDni() + "\"}" +
                ", \"habitacion\": {\"numero\":" + habitacion.getNumero() + "}" +
                "}";
    }
}
