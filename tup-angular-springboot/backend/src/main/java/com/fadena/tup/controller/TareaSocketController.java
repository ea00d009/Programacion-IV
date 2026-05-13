package com.fadena.tup.controller;

import com.fadena.tup.model.Tarea;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TareaSocketController {

  @MessageMapping("/tareas")
  @SendTo("/topic/tareas")
  public Tarea publicarTarea(Tarea tarea) {
    return tarea;
  }
}
