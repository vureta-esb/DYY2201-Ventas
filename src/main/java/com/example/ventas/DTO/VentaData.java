package com.example.ventas.DTO;

import java.util.Date;
import java.util.List;

public class VentaData {

    private List<Long> productos;
    private Date fecha;
    // Constructor vacío
    public VentaData() {
    }
    // Constructor con todos los campos
    public VentaData(List<Long> productos, Date fecha) {
        this.productos = productos;
        this.fecha = fecha;
    }
    // Getters y Setters
    public List<Long> getProductos() {
        return productos;
    }
    public void setProductos(List<Long> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}