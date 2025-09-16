package com.veterinaria.veterinariajava.Services;

import com.veterinaria.veterinariajava.Repository.VentasDetallesRepository;
import com.veterinaria.veterinariajava.Tables.Productos;
import com.veterinaria.veterinariajava.Tables.Ventas;
import com.veterinaria.veterinariajava.Tables.VentasDetalles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasDetallesServices {
    @Autowired
    private VentasDetallesRepository ventasDetallesRepository;


    public VentasDetalles crearDetalle(Ventas venta, Productos producto, int cantidad) {



        VentasDetalles detalle = new VentasDetalles();
        detalle.setVentas(venta);
        detalle.setProductos(producto);
        detalle.setCantidadProductoVendido(cantidad);
        detalle.setPrecioUnitarioPorVenta(producto.getPrecioVenta());
        detalle.setSubtotal(producto.getPrecioVenta() * cantidad);

        return ventasDetallesRepository.save(detalle);
    }

    public List<VentasDetalles> listarPorVenta(Ventas venta) {
        return ventasDetallesRepository.findByVenta(venta);
    }
}
