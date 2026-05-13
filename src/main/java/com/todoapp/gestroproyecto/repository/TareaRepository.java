package com.todoapp.gestroproyecto.repository;

import com.todoapp.gestroproyecto.entity.Proyecto;
import com.todoapp.gestroproyecto.entity.Tarea;
import com.todoapp.gestroproyecto.entity.Usuario;
import com.todoapp.gestroproyecto.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findByProyecto(Proyecto proyecto);

    List<Tarea> findByAsignadoA(Usuario usuario);

    List<Tarea> findByEstado(TaskStatus estado);

    long countByEstado(TaskStatus estado);

    List<Tarea> findByProyectoAndAsignadoA(Proyecto proyecto, Usuario usuario);
}