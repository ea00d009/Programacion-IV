package com.app.tareas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
// Asegúrate de importar tus clases Tarea y TareaRepository según tu proyecto

@Controller
public class TareaSocketController {

    @Autowired
    private TareaRepository repository;

    @MessageMapping("/nueva-tarea")
    @SendTo("/topic/tareas-vivas")
    public Tarea procesarTarea(Tarea tarea) {
        return repository.save(tarea);
    }
}
