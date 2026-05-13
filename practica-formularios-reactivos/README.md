# Práctica: Formularios Reactivos y DTOs en Angular

Este repositorio contiene la resolución de la actividad práctica de Formularios Reactivos para la Tecnicatura Universitaria en Programación.

## Descripción de la Práctica
El proyecto implementa un sistema de alta de productos aplicando buenas prácticas de desarrollo en Angular, incluyendo:
- **Formularios Reactivos:** Gestión del estado y validaciones síncronas/asíncronas desde el controlador.
- **Validaciones Personalizadas:** Control estricto de campos requeridos, longitudes mínimas y valores numéricos (ej. control de stock no negativo).
- **Patrón DTO (Data Transfer Object):** Separación de la lógica de presentación y persistencia mediante interfaces (`ProductoCreateDTO` y `ProductoReadDTO`).
- **Servicios e Inyección de Dependencias:** Uso de `HttpClient` para simular el envío de datos a una API REST y manejo de respuestas mediante `Observables`.

## Estructura Principal
- `src/app/models/` -> Interfaces y DTOs.
- `src/app/services/` -> Lógica de comunicación HTTP.
- `src/app/components/producto-alta/` -> Vista y controlador del formulario de alta.

---
**Autor:** Fabricio Alvarez
