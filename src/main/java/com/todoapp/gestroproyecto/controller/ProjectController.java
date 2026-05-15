package com.todoapp.gestroproyecto.controller;
import com.todoapp.gestroproyecto.entity.Proyecto;
import com.todoapp.gestroproyecto.service.ProyectoService;
import com.todoapp.gestroproyecto.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proyectos")
@RequiredArgsConstructor
public class ProjectController {

    private final ProyectoService proyectoService;
    private final UsuarioService usuarioService;

    // Lista para todos los usuarios autenticados
    @GetMapping
    public String index(Model model) {
        model.addAttribute("listaProyectos", proyectoService.listarProyectos());
        return "proyectos/proyectos";
    }

    // Solo GESTORES y ADMIN pueden ver el formulario de creación
    @GetMapping("/nuevo")
    @PreAuthorize("hasAnyRole('administrador', 'gestor')")
    public String formNuevo(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        model.addAttribute("usuarios", usuarioService.listarUsuarios()); // Para asignar miembros
        return "proyectos/form-proyecto"; 
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasAnyRole('administrador', 'gestor')")
    public String guardar(@ModelAttribute Proyecto proyecto) {
        proyectoService.guardarProyecto(proyecto);
        return "redirect:/proyectos";
    }

    // Solo ADMIN puede borrar
    @GetMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('administrador')")
    public String eliminar(@PathVariable Integer id) {
        proyectoService.eliminarProyecto(id);
        return "redirect:/proyectos";
    }
}