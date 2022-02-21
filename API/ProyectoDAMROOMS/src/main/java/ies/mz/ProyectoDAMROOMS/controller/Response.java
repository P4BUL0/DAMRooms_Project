package ies.mz.ProyectoDAMROOMS.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Response {

    public static final int NO_ERROR = 0;
    public static final int NOT_FOUND = 101;
    public static final String NOTFOUND = "No se ha encontrado";
    public static final String SUCCESSFUL = "Se ha ejecutado correctamente";
    public static final String ERROR_FECHA = "La fecha de inicio tiene que ser anterior a la fecha final";
    private Error error;
    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class Error {
        private long errorCode;
        private String message;
    }
    public static Response noErrorResponse() {
        return new Response(new Error(NO_ERROR, SUCCESSFUL));
    }
    public static Response errorResponse(int errorCode, String
            errorMessage) {
        return new Response(new Error(errorCode, errorMessage));
    }
    public static Response errorFecha(){
        return new Response(new Error(NO_ERROR, ERROR_FECHA));
    }
}
