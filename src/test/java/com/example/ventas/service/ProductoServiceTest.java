package com.example.ventas.service;

import com.example.ventas.model.Producto;
import com.example.ventas.repository.ProductoRepository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {
        // Preparación de datos de prueba
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1L, "Producto 1", 10.0));
        productos.add(new Producto(2L, "Producto 2", 20.0));

        // Simulación del comportamiento del repositorio
        when(productoRepository.findAll()).thenReturn(productos);

        // Ejecución del método a probar
        List<Producto> resultado = productoService.getAll();

        // Verificación de resultados
        assertEquals(productos, resultado);
    }

    @Test
    void testGetById() throws Exception {
        // Preparación de datos de prueba
        Long id = 1L;
        Producto producto = new Producto(id, "Producto 1", 10.0);

        // Simulación del comportamiento del repositorio
        when(productoRepository.findById(id)).thenReturn(Optional.of(producto));

        // Ejecución del método a probar
        Producto resultado = productoService.getById(id);

        // Verificación de resultados
        assertEquals(producto, resultado);
    }

    @Test
    void testGetById_ProductoNoEncontrado() {
        // Preparación de datos de prueba
        Long id = 1L;

        // Simulación del comportamiento del repositorio
        when(productoRepository.findById(id)).thenReturn(Optional.empty());

        // Ejecución del método a probar y verificación de excepción
        assertThrows(Exception.class, () -> productoService.getById(id));
    }

    @Test
    void testDeleteById() {
        // Preparación de datos de prueba
        Long id = 1L;

        // Ejecución del método a probar
        productoService.deleteById(id);

        // Verificación de resultados
        verify(productoRepository, times(1)).deleteById(id);
    }

    @Test
    void testCreate() throws Exception {
        // Preparación de datos de prueba
        Producto producto = new Producto(1L, "Nuevo Producto", 15.0);

        // Simulación del comportamiento del repositorio
        when(productoRepository.save(producto)).thenReturn(producto);

        // Ejecución del método a probar
        Producto resultado = productoService.create(producto);

        // Verificación de resultados
        assertEquals(producto, resultado);
    }
}
