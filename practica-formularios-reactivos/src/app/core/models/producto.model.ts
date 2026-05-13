// DTO para enviar al servidor (Alta)
export interface ProductoCreateDTO {
  nombre: string;
  categoriaId: number; 
  precio: number;
  descripcion?: string;
  stock: number; 
}

// DTO para recibir del servidor (Lectura)
export interface ProductoReadDTO extends ProductoCreateDTO {
  id: number;
  fechaCreacion: Date;
}
