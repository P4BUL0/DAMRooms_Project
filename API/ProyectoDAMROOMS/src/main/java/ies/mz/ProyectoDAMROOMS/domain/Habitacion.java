package ies.mz.ProyectoDAMROOMS.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    private String tipo;

    private String caracteristicas;

    private float importe_noche;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
