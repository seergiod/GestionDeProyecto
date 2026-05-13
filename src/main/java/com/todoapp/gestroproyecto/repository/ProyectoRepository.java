package com.todoapp.gestroproyecto.repository;

import com.todoapp.gestroproyecto.entity.Proyecto;
import com.todoapp.gestroproyecto.entity.Usuario;
import com.todoapp.gestroproyecto.enums.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    List<Proyecto> findByCreador(Usuario creador);

    List<Proyecto> findByMiembrosContaining(Usuario usuario);

    List<Proyecto> findByEstado(ProjectStatus estado);

    long countByEstado(ProjectStatus estado);
}