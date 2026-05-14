package com.todoapp.gestroproyecto.controller;

import com.todoapp.gestroproyecto.entity.Tarea;
import com.todoapp.gestroproyecto.service.ProyectoService;
import com.todoapp.gestroproyecto.service.TareaService;
import com.todoapp.gestroproyecto.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tareas")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;
    private final ProyectoService proyectoService;
    private final UsuarioService usuarioService;

    // LISTAR TAREAS
    @GetMapping
    public String listarTareas(Model model) {

        model.addAttribute(
                "tareas",
                tareaService.listarTareas()
        );

        return "tareas/tareas";
    }

    // FORMULARIO NUEVA TAREA
    @GetMapping("/nuevo")
    @PreAuthorize("hasAnyRole('administrador', 'gestor')")
    public String nuevaTarea(Model model) {

        model.addAttribute(
                "tarea",
                new Tarea()
        );

        // LISTA PROYECTOS
        model.addAttribute(
                "proyectos",
                proyectoService.listarProyectos()
        );

        // LISTA USUARIOS
        model.addAttribute(
                "usuarios",
                usuarioService.listarUsuarios()
        );

        return "tareas/form-tarea";
    }

    // GUARDAR TAREA
    @PostMapping("/guardar")
    @PreAuthorize("hasAnyRole('administrador', 'gestor')")
    public String guardarTarea(@ModelAttribute Tarea tarea) {

        tareaService.guardarTarea(tarea);

        return "redirect:/tareas";
    }

    // FORMULARIO EDITAR
    @GetMapping("/editar/{id}")
    @PreAuthorize("hasAnyRole('administrador', 'gestor')")
    public String editarTarea(
            @PathVariable Integer id,
            Model model
    ) {

        Tarea tarea = tareaService.buscarPorId(id);

        model.addAttribute("tarea", tarea);

        model.addAttribute(
                "proyectos",
                proyectoService.listarProyectos()
        );

        model.addAttribute(
                "usuarios",
                usuarioService.listarUsuarios()
        );

        return "tareas/form-tarea";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('administrador')")
    public String eliminarTarea(@PathVariable Integer id) {

        tareaService.eliminarTarea(id);

        return "redirect:/tareas";
    }
}