import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TareaService } from '../../services/tarea.service';

@Component({
  selector: 'app-nueva-tarea',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './nueva-tarea.component.html'
})
export class NuevaTareaComponent {
  titulo = '';

  constructor(private tareaService: TareaService) {}

  enviar() {
    if (!this.titulo.trim()) return;
    this.tareaService.enviar({ titulo: this.titulo.trim() });
    this.titulo = '';
  }
}
