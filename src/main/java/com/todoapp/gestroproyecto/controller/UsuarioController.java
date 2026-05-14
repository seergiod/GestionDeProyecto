package com.todoapp.gestroproyecto.controller;

import com.todoapp.gestroproyecto.entity.Usuario;
import com.todoapp.gestroproyecto.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@PreAuthorize("hasRole('administrador')")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // LISTAR USUARIOS
    @GetMapping
    public String listarUsuarios(Model model) {

        model.addAttribute(
                "usuarios",
                usuarioService.listarUsuarios()
        );

        return "usuarios/usuarios";
    }

    // FORMULARIO NUEVO USUARIO
    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model) {

        model.addAttribute(
                "usuario",
                new Usuario()
        );

        return "usuarios/form-usuario";
    }

    // GUARDAR USUARIO
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {

        usuarioService.guardarUsuario(usuario);

        return "redirect:/usuarios";
    }

    // FORMULARIO EDITAR
    @GetMapping("/editar/{id}")
    public String editarUsuario(
            @PathVariable Integer id,
            Model model
    ) {

        Usuario usuario = usuarioService.buscarPorId(id);

        model.addAttribute("usuario", usuario);

        return "usuarios/form-usuario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {

        usuarioService.eliminarUsuario(id);

        return "redirect:/usuarios";
    }
}