package com.tup.carrito.services;
import com.tup.carrito.entities.Carrito;

public interface ICarritoService {
    Carrito agregarProducto(Long carritoId, Long productoId, Integer cantidad);
}
