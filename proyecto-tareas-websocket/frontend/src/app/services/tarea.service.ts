import { Injectable } from '@angular/core';
import { Client } from '@stomp/stompjs';

@Injectable({ providedIn: 'root' })
export class TareaService {
  private stompClient: Client; 

  constructor() {
    this.stompClient = new Client({ brokerURL: 'ws://localhost:8080/websocket-endpoint' });
    this.stompClient.activate();
  }

  enviarTareaAlTunel(tarea: any) {
    this.stompClient.publish({
      destination: '/app/nueva-tarea',
      body: JSON.stringify(tarea)
    });
  }

  escucharTareasVivas() {
    return this.stompClient.watch('/topic/tareas-vivas');
  }
}
