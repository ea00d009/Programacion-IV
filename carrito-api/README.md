# carrito-api (Backend) — Programación IV (TUP)

Este entregable corresponde **únicamente** al backend del carrito y se encuentra dentro de la carpeta:

- `carrito-api/`

> Importante: para la corrección, considerar solo el contenido de `carrito-api/`.

## Requisitos

- JDK **17** o superior
- Maven 3.8+

## Cómo ejecutar

Desde la raíz del backend:

```bash
cd carrito-api
mvn spring-boot:run
```

La API quedará disponible por defecto en `http://localhost:8080`.

## Base de datos (H2)

La aplicación usa H2 en memoria.

- Consola H2: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:carritodb`
- User: `sa`
- Password: (vacío)

## Endpoints

### Agregar un producto al carrito

- **POST** `/api/carrito/{id}/productos?productoId={productoId}&cantidad={cantidad}`

Ejemplo:

```bash
curl -X POST "http://localhost:8080/api/carrito/1/productos?productoId=1&cantidad=2"
```

## Contrato de errores (JSON estándar)

Ante errores, el backend debe devolver un JSON consistente (POJO `ErrorResponse`) con:

- `mensaje`
- `codigo`
- `timestamp`

## Guía de pruebas (Postman)

1. **Éxito (200 OK)**: agregar un producto con stock suficiente.
2. **Regla de negocio (400 Bad Request)**:
   - pedir más stock del disponible (lanza `SinStockException`)
   - pedir más de 5 unidades en una operación (lanza `LimiteExcedidoException`)
   - pedir producto con precio `<= 0` (lanza `IllegalArgumentException`)
3. **Recurso inexistente (404 Not Found)**: usar `productoId` inexistente.
4. **Transaccionalidad**: si falla una validación, **no debe** descontar stock ni persistir cambios parciales.

## Notas

- El controlador debe ser “skinny”: delega la lógica al Service.
- La lógica de negocio (validaciones, cálculos) vive en `ICarritoService` / `CarritoServiceImpl`.
- El manejo global de errores se centraliza en `GlobalExceptionHandler` (`@ControllerAdvice`).
