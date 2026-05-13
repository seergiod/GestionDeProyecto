package com.todoapp.gestroproyecto.repository;

import com.todoapp.gestroproyecto.entity.Usuario;
import com.todoapp.gestroproyecto.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Usuario> findByRol(Role rol);
}