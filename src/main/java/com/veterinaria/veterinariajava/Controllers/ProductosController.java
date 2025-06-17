package com.veterinaria.veterinariajava.Controllers;

import java.util.List;
import java.util.Optional;

import com.veterinaria.veterinariajava.DTO.ProductosPageDTO;
import com.veterinaria.veterinariajava.DTO.ProductosRequestDTO;
import com.veterinaria.veterinariajava.DTO.ProductosResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.veterinaria.veterinariajava.Services.ProductosServices;
import com.veterinaria.veterinariajava.Tables.Productos;

@RestController
@RequestMapping("/productos")

public class ProductosController {

    @Autowired
    private ProductosServices productosServices;

    @GetMapping("/{id}")
    public Optional<Productos> obtenerProducto(@PathVariable Integer id){
        return productosServices.obtenerPorId(id);
    }

    @PostMapping
    public ProductosResponseDTO crearProductos(@Valid @RequestBody ProductosRequestDTO dto) {
        ProductosResponseDTO creado = productosServices.guardarProductos(dto);

        System.out.println("ID devuelto en DTO: " + creado.getProductoId());

        return ResponseEntity.ok(creado).getBody();
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productosServices.eliminarProducto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable Integer id, @RequestBody ProductosRequestDTO dto){
        try {
            Productos actualizado = productosServices.actualizarProducto(id, dto);
            return ResponseEntity.ok(actualizado);
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    //GET /productos/buscar?nombre=shampoo

    @GetMapping("/buscar")
    public ResponseEntity<List<ProductosResponseDTO>> buscarProductos(@RequestParam String nombre) {
        List<ProductosResponseDTO> resultado = productosServices.buscarPorNombre(nombre);

        if (resultado.isEmpty()){
            System.out.println("No se han encontrado productos con el nombre: " + nombre);
        }

        return ResponseEntity.ok(resultado);

    }

    @GetMapping("/proveedor/{proveedorId}")
    public ResponseEntity<List<ProductosResponseDTO>> obtenerPorProveedor(@PathVariable Integer proveedorId){
        List<ProductosResponseDTO> productosDTO = productosServices.obtenerProductosPorProveedor(proveedorId);
        return ResponseEntity.ok(productosDTO);
    }


    @GetMapping
    public ResponseEntity<ProductosPageDTO> listarProductosPaginados(Pageable pageable) {
        Page<ProductosResponseDTO> paginaProductos = productosServices.obtenerProductosPageable(pageable);

        ProductosPageDTO respuesta = new ProductosPageDTO(
                paginaProductos.getContent(),
                paginaProductos.getNumber(),
                paginaProductos.getTotalPages(),
                (int) paginaProductos.getTotalElements()
        );
        return ResponseEntity.ok(respuesta);
    }
}
