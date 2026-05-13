package com.todoapp.gestroproyecto.entity;

import com.todoapp.gestroproyecto.enums.Priority;
import com.todoapp.gestroproyecto.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority prioridad = Priority.MEDIA;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus estado = TaskStatus.POR_HACER;

    private LocalDate fechaEntrega;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "asignado_a")
    private Usuario asignadoA;
}