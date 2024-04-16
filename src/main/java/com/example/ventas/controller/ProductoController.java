package com.example.ventas.controller;

import com.example.ventas.model.Producto;
import com.example.ventas.model.Venta;
import com.example.ventas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> producto = productoService.getAll();
        return ResponseEntity.ok(producto);
    }
    @GetMapping("/{id}")
    public Producto getById(@PathVariable Long id) throws Exception {
        return productoService.getById(id);
    }
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) throws Exception {
        Producto nuevoProducto = productoService.create(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productoService.deleteById(id);    
    }
    
}
