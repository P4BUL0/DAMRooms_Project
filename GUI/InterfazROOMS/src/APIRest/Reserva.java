package APIRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    private long idReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float importeTotal;
    private Cliente cliente;
    private Habitacion habitacion;

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
