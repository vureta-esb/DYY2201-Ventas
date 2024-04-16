package com.example.ventas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ventas.model.Venta;



public interface VentaRepository extends JpaRepository<Venta,Long>{

    List<Venta> findByFecha(LocalDate fecha);
    List<Venta> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);

    //public Venta getByFechVenta(Date Fecha);


    
}

