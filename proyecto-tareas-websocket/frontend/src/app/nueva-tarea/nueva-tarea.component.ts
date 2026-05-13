import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TareaService } from '../services/tarea.service';

@Component({
  selector: 'app-nueva-tarea',
  templateUrl: './nueva-tarea.component.html'
})
export class NuevaTareaComponent {
  tareaForm: FormGroup;

  constructor(private fb: FormBuilder, private tareaService: TareaService) {
    this.tareaForm = this.fb.group({
      descripcion: ['', [Validators.required, Validators.minLength(3)]],
      prioridad: ['Baja']
    });
  }

  enviarTarea() {
    if (this.tareaForm.valid) {
      this.tareaService.enviarTareaAlTunel(this.tareaForm.value);
      this.tareaForm.reset({prioridad: 'Baja'});
    }
  }
}
