package APIRest;

public class Habitacion {

    private String tipo;
    private String caracteristicas;
    private float importe_noche;

    public Habitacion(String tipo, String caracteristicas, float importe_noche) {
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.importe_noche = importe_noche;
    }

    @Override
    public String toString() {
        return "{" +
                "\"tipo\": \"" + tipo + "\"" +
                ", \"caracteristicas\": \"" + caracteristicas + "\""+
                ", \"importe_noche\": \"" + importe_noche +
                "\"}";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public float getImporte_noche() {
        return importe_noche;
    }

    public void setImporte_noche(float importe_noche) {
        this.importe_noche = importe_noche;
    }
}
