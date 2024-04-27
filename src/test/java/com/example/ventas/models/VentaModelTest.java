package com.example.ventas.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ventas.model.Producto;
import com.example.ventas.model.Venta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VentaModelTest {

    private Venta venta;

    @BeforeEach
    public void setUp() {
        venta = new Venta();
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        venta.setId(id);
        Assertions.assertEquals(id, venta.getId());
    }

    @Test
    public void testSetAndGetFecha() {
        Date fecha = new Date();
        venta.setFecha(fecha);
        Assertions.assertEquals(fecha, venta.getFecha());
    }

    @Test
    public void testSetAndGetProductos() {
        List<Producto> productos = new ArrayList<>();
        // Añadir productos de prueba
        venta.setProductos(productos);
        Assertions.assertEquals(productos, venta.getProductos());
    }
}
