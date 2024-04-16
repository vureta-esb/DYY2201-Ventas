package com.example.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ventas.repository.ProductoRepository;
import com.example.ventas.model.Producto;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Método para obtener todas los productos
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    // Método para obtener un producto por su ID
    public Producto getById(Long id) throws Exception {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            return optionalProducto.get();
        } else {
            throw new Exception("No se encontró el producto con el ID: " + id);
        }
    }

    // Método para eliminar un producto por su ID
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    // Método para crear un nuevo producto
    public Producto create(Producto producto) throws Exception {
        Objects.requireNonNull(producto, "La información del producto no puede ser nula");
        return productoRepository.save(producto);
    }
}
