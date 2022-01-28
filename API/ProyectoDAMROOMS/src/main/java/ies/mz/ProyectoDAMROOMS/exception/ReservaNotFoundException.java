package ies.mz.ProyectoDAMROOMS.exception;

public class ReservaNotFoundException extends RuntimeException{
    public ReservaNotFoundException() {
        super();
    }
    public ReservaNotFoundException(String message) {
        super(message);
    }
    public ReservaNotFoundException(long id) {
        super("Reserva not found: " + id);
    }
}
