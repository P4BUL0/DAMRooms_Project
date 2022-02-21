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
public class Cliente {

    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private int telefono;

    /**
     *
     * @return Devuelve un String del objeto con formato de json
     */
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
