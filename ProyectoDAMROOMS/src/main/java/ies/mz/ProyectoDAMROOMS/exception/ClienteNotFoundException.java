package ies.mz.ProyectoDAMROOMS.exception;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException() {
        super();
    }
    public ClienteNotFoundException(String message) {
        super(message);
    }
    public ClienteNotFoundException(long id) {
        super("Cliente not found: " + id);
    }
}
