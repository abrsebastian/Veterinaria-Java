package com.veterinaria.veterinariajava.Services;
import java.util.List;
import java.util.Optional;

import com.veterinaria.veterinariajava.DTO.ServicioRequestDTO;
import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;
import com.veterinaria.veterinariajava.Tables.Ganancias;
import com.veterinaria.veterinariajava.Tables.Proveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaria.veterinariajava.Repository.ServiciosRepository;
import com.veterinaria.veterinariajava.Tables.Servicios;
import com.veterinaria.veterinariajava.Services.GananciaService;

@Service
public class ServiciosServices {
    @Autowired
    private ServiciosRepository serviciosRepository;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private GananciaService gananciaService;

    private Servicios mapToEntity(ServicioRequestDTO dto){
        Servicios servicios = new Servicios();

        servicios.setNombreServicio(dto.getNombreServicio());
        servicios.setNombreDelProfesional(dto.getNombreProfesional());
        servicios.setTipoServicio(dto.getTipoServicio());
        servicios.setPrecioServicio(dto.getPrecioBase());

        double precioFinal = dto.getPrecioBase();

        if("Externo".equalsIgnoreCase(String.valueOf(dto.getTipoServicio()))){
            precioFinal += dto.getPrecioBase() * (dto.getComisionServicio()/100);
            servicios.setPorcentajeGananciaLocal(dto.getComisionServicio());
            servicios.setPorcentajeBonificacionEmpleado(0.0);
        }
        else if("Interno".equalsIgnoreCase(String.valueOf(dto.getTipoServicio()))){
            precioFinal -= dto.getPrecioBase() * (dto.getComisionServicio()/100);
            servicios.setPorcentajeBonificacionEmpleado(dto.getComisionServicio());
            servicios.setPorcentajeGananciaLocal(0.0);
        }

        servicios.setPrecioFinal(precioFinal);

        return servicios;
    }

    public List<Servicios>obtenerTodos(){
        return serviciosRepository.findAll();
    }

    public Optional<Servicios>obtenerPorId(Integer id){
        return serviciosRepository.findById(id);
    }

    public Servicios guardarServicio(Servicios servicios){
        Servicios servicioGuardado = serviciosRepository.save(servicios);

        gananciaService.registrarGananciasDesdeServicios(servicioGuardado);
        return servicioGuardado;
    }

    public void eliminarServicio(Integer id){
        serviciosRepository.deleteById(id);
    }

    public Servicios actualizarServicio(Integer id, Servicios servicioActualizado){
        Servicios servicios = serviciosRepository.findById(id).orElseThrow(()-> new RuntimeException("Servicio no encontrado"));

        servicioActualizado.setTipoServicio(servicios.getTipoServicio());
        servicios.setNombreServicio(servicioActualizado.getNombreServicio());
        servicios.setPrecioServicio(servicioActualizado.getPrecioServicio());
        servicios.setNombreDelProfesional(servicioActualizado.getNombreDelProfesional());

        return serviciosRepository.save(servicios);
    }
}
