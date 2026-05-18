# API de Carrito Profesional

Proyecto correspondiente al Trabajo Práctico de Programación IV - TUP (FADENA).
**Autores:** Fabricio Alvarez, Agustín Quiroga, Emanuel Ramírez

## Descripción
Implementación de un sistema de carrito de compras aplicando arquitectura de capas, manejo global de excepciones con `@ControllerAdvice`, y transaccionalidad.

## Pasos de Prueba (Postman)
La base de datos H2 se inicializa en memoria con registros de prueba (Ver `data.sql`).

1. **Prueba de Éxito:** `POST /api/carrito/1/productos?productoId=1&cantidad=2` (Estado 200 OK).
2. **Prueba de Negocio (Límite de unidades):** `POST /api/carrito/1/productos?productoId=1&cantidad=6` (Estado 400 Bad Request - LimiteExcedidoException).
3. **Prueba de Recurso (Inactivo):** `POST /api/carrito/1/productos?productoId=3&cantidad=1` (Estado 404 Not Found - Producto no disponible).
4. **Prueba de Transaccionalidad:** Comprobar que ante fallos en las validaciones, el stock no se descuenta en la base de datos gracias a `@Transactional`.
