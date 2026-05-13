package com.todoapp.gestroproyecto.entity;

import com.todoapp.gestroproyecto.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role rol;

    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    private List<Proyecto> proyectosCreados;

    @OneToMany(mappedBy = "asignadoA", cascade = CascadeType.ALL)
    private List<Tarea> tareasAsignadas;
}