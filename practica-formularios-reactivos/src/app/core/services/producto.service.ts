import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductoCreateDTO, ProductoReadDTO } from '../models/producto.model';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  // URL simulada para la práctica
  private readonly API_URL = 'https://api.tu-servidor.com/productos';

  constructor(private http: HttpClient) {}

  postProducto(producto: ProductoCreateDTO): Observable<ProductoReadDTO> {
    return this.http.post<ProductoReadDTO>(this.API_URL, producto);
  }
}
