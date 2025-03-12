package com.veterinaria.veterinariajava.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.veterinaria.veterinariajava.Repository.ProveedoresRepository;
import com.veterinaria.veterinariajava.Tables.Proveedores;

@Service
public class ProveedoresServices {
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

}
