package com.example.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ventas.repository.VentaRepository;
import com.example.ventas.model.Producto;
import com.example.ventas.model.Venta;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // Método para obtener todas las ventas
    public List<Venta> getAll() {
        return ventaRepository.findAll();
    }

    // Método para obtener una venta por su ID
    public Venta getById(Long id) throws Exception {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró la venta con el ID: " + id));
    }

    // Método para eliminar una venta por su ID
    public void deleteById(Long id) {
        ventaRepository.deleteById(id);
    }

    // Método para crear una nueva venta
    public Venta create(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Método para calcular las ganancias totales de ventas en un día específico
    public double calcularGananciasDiarias(LocalDate fecha) {
        List<Venta> ventasDelDia = ventaRepository.findByFecha(fecha);
        return calcularTotalGanancias(ventasDelDia);
    }

    // Método para calcular las ganancias totales de ventas en un mes y año específico
    public double calcularGananciasMensuales(int mes, int anio) {
        YearMonth yearMonth = YearMonth.of(anio, mes);
        LocalDate inicioMes = yearMonth.atDay(1);
        LocalDate finMes = yearMonth.atEndOfMonth();
        List<Venta> ventasDelMes = ventaRepository.findByFechaBetween(inicioMes, finMes);
        return calcularTotalGanancias(ventasDelMes);
    }

    // Método para calcular las ganancias totales de ventas en un año específico
    public double calcularGananciasAnuales(int anio) {
        Year year = Year.of(anio);
        LocalDate inicioAnio = year.atDay(1);
        LocalDate finAnio = year.atDay(year.length());
        List<Venta> ventasDelAnio = ventaRepository.findByFechaBetween(inicioAnio, finAnio);
        return calcularTotalGanancias(ventasDelAnio);
    }

    // Método auxiliar para calcular el total de ganancias de una lista de ventas
    private double calcularTotalGanancias(List<Venta> ventas) {
        double totalGanancias = 0.0;
        for (Venta venta : ventas) {
            totalGanancias += calcularPrecioTotalVenta(venta);
        }
        return totalGanancias;
    }

    // Método auxiliar para calcular el precio total de una venta
    private double calcularPrecioTotalVenta(Venta venta) {
        double precioTotal = 0.0;
        List<Producto> productos = venta.getProductos();
        for (Producto producto : productos) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }
}
