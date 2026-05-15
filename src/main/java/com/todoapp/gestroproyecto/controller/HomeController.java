package com.todoapp.gestroproyecto.controller;

import com.todoapp.gestroproyecto.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UsuarioService usuarioService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {

        model.addAttribute(
                "totalUsuarios",
                usuarioService.contarUsuarios()
        );

        return "home";
    }
}