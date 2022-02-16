package APIRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float importeTotal;
    private String estado;
    private Cliente clientes;//Comprobar
    private Habitacion habitacion;//Comprobar

    public void calcImporteTotal(){
        float importeNoche = this.getHabitacion().getImporte_noche();
        long total_dias = DAYS.between(this.fechaInicio, this.fechaFin);
        this.importeTotal = importeNoche * total_dias;
    }

    @Override
    public String toString(){
        return "{" +
                "\"fechaInicio\": \"" + fechaInicio + "\"" +
                "\"fechaFin\": \"" + fechaFin + "\"" +
                "\"importeTotal\": \"" + importeTotal + "\"" +
                "\"estado\": \"" + estado +
                "\"}";
    }
}
