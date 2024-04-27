package com.example.ventas.models;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ventas.model.Producto;
import com.example.ventas.model.Venta;

import java.util.ArrayList;
import java.util.List;

public class ProductoModelTest {

    private Producto producto;

    @BeforeEach
    public void setUp() {
    producto = new Producto(); // Inicializar el objeto producto
        }
    public void testSetAndGetId() {
        Long id = 1L;
        producto.setId(id);
        Assertions.assertEquals(id, producto.getId());
    }

    @Test
    public void testSetAndGetName() {
        String nombre = "Producto de prueba";
        producto.setNombre(nombre);
        Assertions.assertEquals(nombre, producto.getNombre());
    }

    @Test
    public void testSetAndGetPrecio() {
        Double precio = 10.5;
        producto.setPrecio(precio);
        Assertions.assertEquals(precio, producto.getPrecio());
    }

    @Test
    public void testSetAndGetVentas() {
        List<Venta> ventas = new ArrayList<>();
        // Añadir ventas de prueba
        producto.setVentas(ventas);
        Assertions.assertEquals(ventas, producto.getVentas());
    }
}
