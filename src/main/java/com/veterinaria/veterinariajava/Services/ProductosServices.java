package com.veterinaria.veterinariajava.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.veterinaria.veterinariajava.DTO.ProductosRequestDTO;
import com.veterinaria.veterinariajava.DTO.ProductosResponseDTO;
import com.veterinaria.veterinariajava.Repository.CategoriasRepository;
import com.veterinaria.veterinariajava.Repository.ProveedoresRepository;
import com.veterinaria.veterinariajava.Tables.Proveedores;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import com.veterinaria.veterinariajava.Repository.ProductosRepository;

import com.veterinaria.veterinariajava.Tables.Productos;

@Service
public class ProductosServices {
    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @Autowired
    private CategoriasRepository categoriasRepository;

    public List<Productos>obtenerTodos(){
        return productosRepository.findAll();
    }

    public Optional<Productos>obtenerPorId(Integer id){
        return productosRepository.findById(id);
    }

    public List<ProductosResponseDTO>obtenerProductosPorProveedor(Integer proveedorId){
        List<Productos> productos = productosRepository.findByProveedorId(proveedorId);

        return productos.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public Page<ProductosResponseDTO>obtenerProductosPageable(Pageable pageable){

        Page<Productos> paginaProductos = productosRepository.findAll(pageable);

        Page<ProductosResponseDTO> paginaDTO = paginaProductos.map(productos -> {
            ProductosResponseDTO dto = new ProductosResponseDTO();
            dto.setNombreProducto(productos.getNombreProducto());
            dto.setPrecioProducto(productos.getPrecioUnitario());
            dto.setStockProducto(productos.getStock());
            if(productos.getProveedor() != null){
                dto.setProveedorId(productos.getProveedor().getProveedorId());
                dto.setNombreProveedor(productos.getProveedor().getNombreProveedor());
            }
            return dto;
        });

        return paginaDTO;
    }

    private Productos mapToEntity(ProductosRequestDTO dto){
        Proveedores proveedores = proveedoresRepository.findById(dto.getProveedorId()).
                orElseThrow(()-> new EntityNotFoundException("Proveedor no encontrado"));

        Productos productos = new Productos();

        productos.setNombreProducto(dto.getNombreProducto());
        productos.setPrecioUnitario(dto.getPrecioProducto());
        productos.setStock(dto.getStockProducto());
        productos.setProveedor(proveedores);

        return productos;
    }

    private ProductosResponseDTO mapToResponseDTO(Productos productos){
        ProductosResponseDTO dto = new ProductosResponseDTO();
        dto.setNombreProducto(productos.getNombreProducto());
        dto.setPrecioProducto(productos.getPrecioUnitario());
        dto.setStockProducto(productos.getStock());

        if(productos.getProveedor() != null){
            dto.setProveedorId(productos.getProveedor().getProveedorId());
            dto.setNombreProveedor(productos.getProveedor().getNombreProveedor());
        }

        return dto;
    }

    //Bloque de codigo responsable de que productos anide las tablas proveedores y categorias

    public ProductosResponseDTO guardarProductos(ProductosRequestDTO dto){
        Productos productos = mapToEntity(dto);
        Productos productoGuardado = productosRepository.save(productos);
        return mapToResponseDTO(productoGuardado);
    }

    public List<ProductosResponseDTO> buscarPorNombre(String nombre) {
        List<Productos> productos = productosRepository.findByNombreContainingIgnoreCase(nombre);
        return productos.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public Productos actualizarProducto(Integer id, ProductosRequestDTO dto){
        Productos productoExistente = productosRepository.findById(id).orElseThrow(()-> new RuntimeException("Producto no encontrado"));

        productoExistente.setNombreProducto(dto.getNombreProducto());
        productoExistente.setStock(dto.getStockProducto());
        productoExistente.setPrecioUnitario(dto.getPrecioProducto());
        Integer proveedorId = dto.getProveedorId();

        Proveedores proveedores = proveedoresRepository.findById(proveedorId).
                orElseThrow(()-> new RuntimeException("Proveedor no encontrado"));

        productoExistente.setProveedor(proveedores);

        return productosRepository.save(productoExistente);
    }

    public void eliminarProducto(Integer id){
        productosRepository.deleteById(id);
    }

}
