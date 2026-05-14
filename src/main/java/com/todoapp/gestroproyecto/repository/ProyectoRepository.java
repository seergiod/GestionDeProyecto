package com.todoapp.gestroproyecto.repository;

import com.todoapp.gestroproyecto.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
}