package com.example.ventas.service;

import com.example.ventas.model.Producto;
import com.example.ventas.model.Venta;
import com.example.ventas.repository.VentaRepository;
import com.example.ventas.service.VentaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class VentaServiceTest {

    @Mock
    private VentaRepository ventaRepository;

    @InjectMocks
    private VentaService ventaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCalcularGananciasDiarias() {
        // Preparación de datos de prueba
        LocalDate fecha = LocalDate.now();
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1L, "Producto 1", 50.0));
        productos.add(new Producto(2L, "Producto 2", 50.0));
        Venta venta = new Venta(new Date(), productos);

        // Simulación del comportamiento del repositorio
        when(ventaRepository.findByFecha(fecha)).thenReturn(List.of(venta));

        // Ejecución del método a probar
        double ganancias = ventaService.calcularGananciasDiarias(fecha);

        // Verificación de resultados
        assertEquals(100.0, ganancias);
    }

    @Test
    void testGetAll() {
        // Preparación de datos de prueba
        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(new Date(), new ArrayList<Producto>()));

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
        Venta venta = new Venta(new Date(), new ArrayList<Producto>());

        // Simulación del comportamiento del repositorio
        when(ventaRepository.findById(id)).thenReturn(java.util.Optional.of(venta));

        // Ejecución del método a probar
        Venta resultado = ventaService.getById(id);

        // Verificación de resultados
        assertEquals(venta, resultado);
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
}