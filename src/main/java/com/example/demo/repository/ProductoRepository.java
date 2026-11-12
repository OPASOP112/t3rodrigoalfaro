package com.example.demo.repository;

import com.example.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // CORREGIDO: Ahora usa precioVenta en lugar de precio
    @Query("SELECT p FROM Producto p WHERE p.precioVenta <= :precioMax ORDER BY p.precioVenta DESC")
    List<Producto> buscarPorPrecioMaximoJPQL(@Param("precioMax") BigDecimal precioMax);

    List<Producto> findByCategoriaNamed(@Param("categoria") String categoria);
}