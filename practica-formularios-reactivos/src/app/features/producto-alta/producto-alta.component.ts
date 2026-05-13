import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProductoService } from '../../services/producto.service';
import { ProductoCreateDTO } from '../../models/producto.model';

@Component({
  selector: 'app-producto-alta',
  templateUrl: './producto-alta.component.html',
  styleUrls: ['./producto-alta.component.css'] // Opcional si agregas estilos
})
export class ProductoAltaComponent {
  productoForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private productoService: ProductoService
  ) {
    this.productoForm = this.fb.group({
      nombre: ['', [Validators.required, Validators.minLength(3)]],
      categoria: ['', Validators.required],
      precio: [null, [Validators.required, Validators.min(1)]],
      descripcion: [''],
      stock: [null, [Validators.required, Validators.min(0)]] 
    });
  }

  guardar() {
    if (this.productoForm.valid) {
      const formValue = this.productoForm.value;
      
      const nuevoProducto: ProductoCreateDTO = {
        ...formValue,
        categoriaId: Number(formValue.categoria)
      };
      
      delete (nuevoProducto as any).categoria;

      this.productoService.postProducto(nuevoProducto).subscribe({
        next: (respuesta) => {
          console.log('Producto guardado con éxito', respuesta);
          alert('¡Producto creado exitosamente!');
          this.productoForm.reset();
        },
        error: (err) => {
          console.error('Error al guardar', err);
          alert('Ocurrió un error al procesar el alta.');
        }
      });
    }
  }
}
