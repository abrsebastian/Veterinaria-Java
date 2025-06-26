package com.veterinaria.veterinariajava.Services;
import java.util.List;
import java.util.Optional;

import com.veterinaria.veterinariajava.DTO.ServiciosInternosRequestDTO;
import com.veterinaria.veterinariajava.DTO.ServiciosInternosResponseDTO;
import com.veterinaria.veterinariajava.Repository.EmpleadosRepository;
import com.veterinaria.veterinariajava.Tables.Empleados;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaria.veterinariajava.Repository.ServiciosInternosRepository;
import com.veterinaria.veterinariajava.Tables.ServiciosInternos;

@Service
public class ServiciosInternosServices {
    @Autowired
    private ServiciosInternosRepository serviciosInternosRepository;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private GananciaService gananciaService;

    @Autowired
    private EmpleadosService empleadosService;

    private ServiciosInternosResponseDTO mapToEntity(ServiciosInternos serviciosInternos){
        ServiciosInternosResponseDTO dto = new ServiciosInternosResponseDTO();
        dto.setServicioId(serviciosInternos.getServicioId());
        dto.setEmpleadoId(serviciosInternos.getEmpleados().getEmpleadoId());
        dto.setNombreServicio(serviciosInternos.getNombreServicio());
        dto.setNombreEmpleado(serviciosInternos.getNombreDelProfesional());
        dto.setPrecioBase(serviciosInternos.getPrecioServicio());
        dto.setPorcentajeEmpleado(serviciosInternos.getPorcentajeEmpleado());
        dto.setPrecioFinal(serviciosInternos.getPrecioFinal());

        return dto;
    }



    public List<ServiciosInternosResponseDTO> obtenerTodosLosServicios(){
        return serviciosInternosRepository.findAll().stream()
                .map(this::mapToEntity).toList();
    }

    @Transactional
    public ServiciosInternosResponseDTO registrarServicioInterno(ServiciosInternosRequestDTO dto){
        ServiciosInternos serviciosInternos = new ServiciosInternos();

        Empleados empleados = empleadosRepository.findById(dto.getIdProfesional())
                .orElseThrow(()-> new RuntimeException("Empleado no encontrado"));

        //calcular datos Precio base, porcentaje empleado preciofinal

        double precioBase = dto.getPrecioBase();
        double porcentajeEmpleado = precioBase * (dto.getPorcentajeComision()/100);
        double precioFinal = precioBase - porcentajeEmpleado;

        //actualizar empleadoService y ganancias

        empleados.setComisionPorServicio(empleados.getComisionPorServicio() + porcentajeEmpleado);
        empleadosService.calcularSueldoFinal(empleados.getEmpleadoId());

        serviciosInternos.setNombreServicio(dto.getNombreServicio());
        serviciosInternos.setPrecioServicio(dto.getPrecioBase());
        serviciosInternos.setPorcentajeEmpleado(porcentajeEmpleado);
        serviciosInternos.setPrecioFinal(precioFinal);
        serviciosInternos.setNombreDelProfesional(empleados.getNombreEmpleado());

        serviciosInternos.setEmpleados(empleados); //Lo he agregado recientemente


      //  ServiciosInternos nuevoSI = new ServiciosInternos();

        ServiciosInternos SIGuardado = serviciosInternosRepository.save(serviciosInternos);

        //Devolver DTO

        return mapToEntity(SIGuardado);

    }

    public List<ServiciosInternos>obtenerTodos(){
        return serviciosInternosRepository.findAll();
    }

    public Optional<ServiciosInternos>obtenerPorId(Integer id){
        return serviciosInternosRepository.findById(id);
    }

    public ServiciosInternos guardarServicio(ServiciosInternos servicios){
        ServiciosInternos servicioGuardado = serviciosInternosRepository.save(servicios);

        gananciaService.registrarGananciaServicioInterno(servicioGuardado);
        return servicioGuardado;
    }

    public void eliminarServicio(Integer id){
        serviciosInternosRepository.deleteById(id);
    }

    public ServiciosInternos actualizarServicio(Integer id, ServiciosInternos servicioActualizado){
        ServiciosInternos servicios = serviciosInternosRepository.findById(id).orElseThrow(()-> new RuntimeException("Servicio no encontrado"));

        servicios.setNombreServicio(servicioActualizado.getNombreServicio());
        servicios.setPrecioServicio(servicioActualizado.getPrecioServicio());
        servicios.setNombreDelProfesional(servicioActualizado.getNombreDelProfesional());

        return serviciosInternosRepository.save(servicios);
    }
}
