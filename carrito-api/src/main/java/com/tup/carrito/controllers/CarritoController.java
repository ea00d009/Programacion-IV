package com.tup.carrito.controllers;

import com.tup.carrito.entities.Carrito;
import com.tup.carrito.services.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    private ICarritoService carritoService;

    @PostMapping("/{id}/productos")
    public ResponseEntity<Carrito> agregarProductoAlCarrito(
            @PathVariable Long id,
            @RequestParam Long productoId,
            @RequestParam Integer cantidad) {
        
        // El controlador queda completamente limpio. Todas las validaciones
        // y cálculos ocurren en la Service Layer.
        Carrito carrito = carritoService.agregarProducto(id, productoId, cantidad);
        return ResponseEntity.ok(carrito);
    }
}
