package com.example.ventas.repository;

import com.example.ventas.model.Venta;
import com.example.ventas.repository.VentaRepository;
import com.example.ventas.service.VentaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VentaRepositoryTest {

    @Mock
    private VentaRepository ventaRepository;

    @InjectMocks
    private VentaService ventaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {
        // Preparación de datos de prueba
        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta()); // Agrega detalles específicos si son necesarios
        ventas.add(new Venta());

        // Simulación del comportamiento del repositorio
        when(ventaRepository.findAll()).thenReturn(ventas);

        // Ejecución del método a probar
        List<Venta> resultado = ventaService.getAll();

        // Verificación de resultados
        assertEquals(ventas, resultado);
    }

    @Test
    void testGetById() throws Exception {
        // Preparación de datos de prueba
        Long id = 1L;
        Venta venta = new Venta(); // Configura los detalles de la venta

        // Simulación del comportamiento del repositorio
        when(ventaRepository.findById(id)).thenReturn(Optional.of(venta));

        // Ejecución del método a probar
        Venta resultado = ventaService.getById(id);

        // Verificación de resultados
        assertEquals(venta, resultado);
    }

    @Test
    void testGetById_VentaNoEncontrada() {
        // Preparación de datos de prueba
        Long id = 1L;

        // Simulación del comportamiento del repositorio
        when(ventaRepository.findById(id)).thenReturn(Optional.empty());

        // Ejecución del método a probar y verificación de excepción
        assertThrows(Exception.class, () -> ventaService.getById(id));
    }

    @Test
    void testDeleteById() {
        // Preparación de datos de prueba
        Long id = 1L;

        // Ejecución del método a probar
        ventaService.deleteById(id);

        // Verificación de resultados
        verify(ventaRepository, times(1)).deleteById(id);
    }

    @Test
    void testCreate() {
        // Preparación de datos de prueba
        Venta venta = new Venta(); // Configura los detalles de la venta

        // Simulación del comportamiento del repositorio
        when(ventaRepository.save(any(Venta.class))).thenReturn(venta);

        // Ejecución del método a probar
        Venta resultado = ventaService.create(venta);

        // Verificación de resultados
        assertEquals(venta, resultado);
    }
}
