import { Injectable } from '@angular/core';
import { Client, IMessage } from '@stomp/stompjs';
import { BehaviorSubject, Observable } from 'rxjs';
import { Tarea } from '../models/tarea.model';

@Injectable({ providedIn: 'root' })
export class TareaService {
  private client: Client;
  private tareasSubject = new BehaviorSubject<Tarea[]>([]);

  tareas$: Observable<Tarea[]> = this.tareasSubject.asObservable();

  constructor() {
    this.client = new Client({
      brokerURL: 'ws://localhost:8080/ws',
      reconnectDelay: 5000
    });

    this.client.onConnect = () => {
      this.client.subscribe('/topic/tareas', (message: IMessage) => {
        const tarea = JSON.parse(message.body) as Tarea;
        this.tareasSubject.next([...this.tareasSubject.value, tarea]);
      });
    };

    this.client.activate();
  }

  enviar(tarea: Tarea) {
    this.client.publish({ destination: '/app/tareas', body: JSON.stringify(tarea) });
  }
}
