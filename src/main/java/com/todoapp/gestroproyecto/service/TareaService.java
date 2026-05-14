package com.todoapp.gestroproyecto.service;

import com.todoapp.gestroproyecto.entity.Tarea;
import com.todoapp.gestroproyecto.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TareaService {

    private final TareaRepository tareaRepository;

    // LISTAR TODAS
    public List<Tarea> listarTareas() {

        return tareaRepository.findAll();
    }

    // BUSCAR POR ID
    public Tarea buscarPorId(Integer id) {

        Optional<Tarea> tarea = tareaRepository.findById(id);

        return tarea.orElse(null);
    }

    // GUARDAR
    public Tarea guardarTarea(Tarea tarea) {

        return tareaRepository.save(tarea);
    }

    // ACTUALIZAR
    public Tarea actualizarTarea(Tarea tarea) {

        return tareaRepository.save(tarea);
    }

    // ELIMINAR
    public void eliminarTarea(Integer id) {

        tareaRepository.deleteById(id);
    }
}