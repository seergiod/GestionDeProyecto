package com.todoapp.gestroproyecto.service;

import com.todoapp.gestroproyecto.entity.Proyecto;
import com.todoapp.gestroproyecto.repository.ProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    // LISTAR TODOS
    public List<Proyecto> listarProyectos() {

        return proyectoRepository.findAll();
    }

    // BUSCAR POR ID
    public Proyecto buscarPorId(Integer id) {

        Optional<Proyecto> proyecto = proyectoRepository.findById(id);

        return proyecto.orElse(null);
    }

    // GUARDAR
    public Proyecto guardarProyecto(Proyecto proyecto) {

        return proyectoRepository.save(proyecto);
    }

    // ACTUALIZAR
    public Proyecto actualizarProyecto(Proyecto proyecto) {

        return proyectoRepository.save(proyecto);
    }

    // ELIMINAR
    public void eliminarProyecto(Integer id) {

        proyectoRepository.deleteById(id);
    }
}