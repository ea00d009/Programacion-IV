package com.tup.carrito.services;
import com.tup.carrito.dtos.CarritoDTO;
import com.tup.carrito.entities.Carrito;

public interface ICarritoService {
    Carrito agregarProducto(Long carritoId, Long productoId, Integer cantidad);
    CarritoDTO obtenerCarritoOptimizado(Long usuarioId);
}
