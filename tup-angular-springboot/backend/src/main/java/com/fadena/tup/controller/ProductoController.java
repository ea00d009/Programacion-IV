package com.fadena.tup.controller;

import com.fadena.tup.dto.ProductoCreateDTO;
import com.fadena.tup.dto.ProductoReadDTO;
import com.fadena.tup.model.Producto;
import com.fadena.tup.repository.ProductoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

  private final ProductoRepository productoRepository;

  public ProductoController(ProductoRepository productoRepository) {
    this.productoRepository = productoRepository;
  }

  @GetMapping
  public List<ProductoReadDTO> listar() {
    return productoRepository.findAll().stream().map(this::toReadDTO).collect(Collectors.toList());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductoReadDTO crear(@RequestBody ProductoCreateDTO dto) {
    Producto p = new Producto();
    p.setNombre(dto.nombre());
    p.setPrecio(dto.precio());
    p = productoRepository.save(p);
    return toReadDTO(p);
  }

  private ProductoReadDTO toReadDTO(Producto p) {
    return new ProductoReadDTO(p.getId(), p.getNombre(), p.getPrecio());
  }
}
