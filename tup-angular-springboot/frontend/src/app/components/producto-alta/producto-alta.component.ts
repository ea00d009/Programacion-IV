import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ProductoService } from '../../services/producto.service';
import { ProductoCreateDTO } from '../../models/producto.dto';

@Component({
  selector: 'app-producto-alta',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './producto-alta.component.html'
})
export class ProductoAltaComponent {
  nombre = '';
  precio: number | null = null;

  constructor(private productoService: ProductoService) {}

  guardar() {
    if (!this.nombre.trim()) return;
    if (this.precio === null || this.precio <= 0) return;

    const dto: ProductoCreateDTO = {
      nombre: this.nombre.trim(),
      precio: this.precio
    };

    this.productoService.crear(dto).subscribe(() => {
      this.nombre = '';
      this.precio = null;
    });
  }
}
