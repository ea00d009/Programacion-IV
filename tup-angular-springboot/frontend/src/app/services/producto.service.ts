import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductoCreateDTO, ProductoReadDTO } from '../models/producto.dto';

@Injectable({ providedIn: 'root' })
export class ProductoService {
  private readonly baseUrl = 'http://localhost:8080/api/productos';

  constructor(private http: HttpClient) {}

  crear(dto: ProductoCreateDTO): Observable<ProductoReadDTO> {
    return this.http.post<ProductoReadDTO>(this.baseUrl, dto);
  }

  listar(): Observable<ProductoReadDTO[]> {
    return this.http.get<ProductoReadDTO[]>(this.baseUrl);
  }
}
