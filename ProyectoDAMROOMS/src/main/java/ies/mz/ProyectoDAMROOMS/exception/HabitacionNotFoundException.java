package ies.mz.ProyectoDAMROOMS.exception;

public class HabitacionNotFoundException extends RuntimeException{
    public HabitacionNotFoundException() {
        super();
    }
    public HabitacionNotFoundException(String message) {
        super(message);
    }
    public HabitacionNotFoundException(long id) {
        super("Habitacion not found: " + id);
    }
}
