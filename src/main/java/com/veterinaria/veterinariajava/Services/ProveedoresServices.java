package com.veterinaria.veterinariajava.Services;
import java.util.List;
import java.util.Optional;

import com.veterinaria.veterinariajava.Tables.Categorias;
import com.veterinaria.veterinariajava.Tables.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaria.veterinariajava.Repository.ProveedoresRepository;
import com.veterinaria.veterinariajava.Tables.Proveedores;

@Service
public class ProveedoresServices {
    @Autowired
    private ProveedoresRepository proveedoresRepository;

    public List<Proveedores>obtenerTodos(){
        return proveedoresRepository.findAll();
    }

    public Optional<Proveedores>obtenerPorId(Integer id){
        return proveedoresRepository.findById(id);
    }

    public Proveedores guardaProveedores(Proveedores proveedores){
        return proveedoresRepository.save(proveedores);
    }

    public void eliminarProveedor(Integer id){
        proveedoresRepository.deleteById(id);
    }

    public Proveedores actualizarProveedor(Integer id, Proveedores proveedorActualizado){
        Proveedores proveedores = proveedoresRepository.findById(id).orElseThrow(()-> new RuntimeException("Proveedor no encontrado"));

        proveedores.setNombreProveedor(proveedorActualizado.getNombreProveedor());
        proveedores.setTelefono(proveedorActualizado.getTelefono());
        proveedores.setEmail(proveedorActualizado.getEmail());

        return proveedoresRepository.save(proveedores);
    }

}
