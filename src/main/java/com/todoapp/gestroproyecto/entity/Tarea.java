package com.todoapp.gestroproyecto.entity;

import com.todoapp.gestroproyecto.enums.Priority;
import com.todoapp.gestroproyecto.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tareas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "usuario_asignado")
    private Usuario usuarioAsignado;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Priority prioridad;

    @Enumerated(EnumType.STRING)
    private TaskStatus estado;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;
}