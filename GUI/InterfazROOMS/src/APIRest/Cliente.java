package APIRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private int telefono;

    @Override
    public String toString(){
        return "{"+
                "\"dni\": \"" + dni + "\"" +
                ", \"nombre\": \"" + nombre + "\"" +
                ", \"apellidos\": \""+ apellidos + "\""+
                ", \"direccion\": \""+ direccion + "\""+
                ", \"telefono\": \"" + telefono +
                "\"}";
    }
}
