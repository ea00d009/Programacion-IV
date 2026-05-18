package com.tup.carrito.exceptions;

public class SinStockException extends RuntimeException {
    public SinStockException(String message) {
        super(message);
    }
}
