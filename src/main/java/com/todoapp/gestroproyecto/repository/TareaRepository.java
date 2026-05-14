package com.todoapp.gestroproyecto.repository;

import com.todoapp.gestroproyecto.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}