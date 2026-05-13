# Gestor de Tareas en Tiempo Real 🚀

Este proyecto es una aplicación *Full-Stack* orientada a eventos, desarrollada como parte de las prácticas de la Tecnicatura Universitaria en Programacion (FRCU-UTN). Su objetivo principal es demostrar la implementación de una arquitectura bidireccional (Full-Duplex) utilizando WebSockets para la sincronización de datos en tiempo real entre múltiples clientes.

## 📋 Características Principales

* **Control de Estado en el Cliente:** Utilización de Formularios Reactivos (Model-Driven Forms) para asegurar que los datos nazcan validados y limpios directamente desde TypeScript.
* **Comunicación Bidireccional:** Implementación de un "túnel" de datos persistente mediante WebSockets, evitando el tradicional ciclo de petición-respuesta HTTP y las recargas de página (F5).
* **Consumo de Streams:** Manejo del flujo de datos asíncrono con RxJS y el `AsyncPipe` de Angular para prevenir fugas de memoria.
* **Backend como Broker:** El servidor Spring Boot actúa como un retransmisor que recibe la nueva tarea, la persiste y la emite automáticamente a todos los suscriptores conectados al tópico.

## 🛠️ Tecnologías Utilizadas

**Frontend:**
* [Angular](https://angular.io/) (Framework principal)
* Reactive Forms (FormBuilder, FormGroup, FormControl)
* RxJS (Observables)
* `@stomp/stompjs` (Cliente STOMP para WebSockets)

**Backend:**
* [Java Spring Boot](https://spring.io/projects/spring-boot)
* Spring WebSockets / Messaging
* Spring Data JPA (Persistencia de datos)

## ⚙️ Estructura del Proyecto

El repositorio está dividido en dos aplicaciones principales:

```text
/
├── frontend/     # Aplicación cliente en Angular
└── backend/      # API y Broker WebSocket en Spring Boot
