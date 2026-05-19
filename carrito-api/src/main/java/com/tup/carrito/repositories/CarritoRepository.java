package com.tup.carrito.repositories;

import com.tup.carrito.entities.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    @Query("SELECT DISTINCT c FROM Carrito c " +
           "JOIN FETCH c.items i " +
           "JOIN FETCH i.producto " +
           "WHERE c.id = :usuarioId")
    Optional<Carrito> findCarritoFull(@Param("usuarioId") Long usuarioId);
}
