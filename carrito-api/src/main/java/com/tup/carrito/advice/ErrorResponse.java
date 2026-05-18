package com.tup.carrito.advice;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String mensaje;
    private int estadoHttp;
    private LocalDateTime timestamp;

    public ErrorResponse(String mensaje, int estadoHttp, LocalDateTime timestamp) {
        this.mensaje = mensaje;
        this.estadoHttp = estadoHttp;
        this.timestamp = timestamp;
    }

    public String getMensaje() { return mensaje; }
    public int getEstadoHttp() { return estadoHttp; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
