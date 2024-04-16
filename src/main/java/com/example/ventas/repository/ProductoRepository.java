package com.example.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ventas.model.Producto;
import java.util.List;

// Define la interfaz del repositorio extendiendo JpaRepository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // JpaRepository<Producto, Long> indica que este repositorio maneja entidades 'Producto',
    // con una clave primaria de tipo 'Long'

    // Método de consulta para encontrar productos por nombre
    List<Producto> findByNombre(String nombre);

   
}
