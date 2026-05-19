package com.tup.carrito.services.impl;

import com.tup.carrito.dtos.CarritoDTO;
import com.tup.carrito.entities.Carrito;
import com.tup.carrito.entities.ItemCarrito;
import com.tup.carrito.entities.Producto;
import com.tup.carrito.exceptions.LimiteExcedidoException;
import com.tup.carrito.exceptions.ResourceNotFoundException;
import com.tup.carrito.exceptions.SinStockException;
import com.tup.carrito.repositories.CarritoRepository;
import com.tup.carrito.repositories.ProductoRepository;
import com.tup.carrito.services.ICarritoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarritoServiceImpl implements ICarritoService {

    @Autowired
    private ProductoRepository productoRepo;
    
    @Autowired
    private CarritoRepository carritoRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public Carrito agregarProducto(Long carritoId, Long productoId, Integer cantidad) {
        // 1. Verificar si el producto existe
        Producto producto = productoRepo.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        // 2. Validación de Estado del Producto (Desafío 1.3)
        if (!producto.isActivo()) {
            throw new ResourceNotFoundException("El producto no está disponible para la venta");
        }

        // 3. Validación de Precio Cero (Desafío 1.2)
        if (producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio del producto debe ser mayor a 0");
        }

        // 4. Límite de Unidades (Desafío 1.1)
        if (cantidad > 5) {
            throw new LimiteExcedidoException("No se pueden agregar más de 5 unidades del mismo producto");
        }

        // 5. Validación de Stock
        if (cantidad > producto.getStockDisponible()) {
            throw new SinStockException("Stock insuficiente para el producto seleccionado");
        }

        // Buscar carrito o crear uno nuevo si es el primero
        Carrito carrito = carritoRepo.findById(carritoId).orElse(new Carrito());

        // Descontar stock y armar el ítem
        producto.setStockDisponible(producto.getStockDisponible() - cantidad);
        productoRepo.save(producto);

        ItemCarrito item = new ItemCarrito();
        item.setProducto(producto);
        item.setCantidad(cantidad);
        item.setSubtotal(producto.getPrecio() * cantidad);

        carrito.getItems().add(item);
        carrito.setTotal(carrito.getTotal() + item.getSubtotal());

        return carritoRepo.save(carrito);
    }

    @Override
    @Transactional(readOnly = true)
    public CarritoDTO obtenerCarritoOptimizado(Long usuarioId) {
        Carrito carrito = carritoRepo.findCarritoFull(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el carrito"));
        return modelMapper.map(carrito, CarritoDTO.class);
    }
}
