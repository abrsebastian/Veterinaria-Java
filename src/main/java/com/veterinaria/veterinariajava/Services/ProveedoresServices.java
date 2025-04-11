package com.veterinaria.veterinariajava.Services;
import java.util.List;
import java.util.Optional;

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
        proveedoresRepository.findById(id).map(proveedores -> {
            proveedores.setNombreProveedor(proveedorActualizado.getNombreProveedor());
            proveedores.setEmail(proveedorActualizado.getEmail());
            proveedores.setTelefono(proveedorActualizado.getTelefono());
            return proveedoresRepository.save(proveedores);
        });
        return proveedorActualizado;
    }

}
