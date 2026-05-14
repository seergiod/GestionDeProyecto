package com.todoapp.gestroproyecto.service;

import com.todoapp.gestroproyecto.entity.Usuario;
import com.todoapp.gestroproyecto.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // LISTAR TODOS
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // BUSCAR POR ID
    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return usuario.orElse(null);
    }

    // BUSCAR POR EMAIL
    public Usuario buscarPorEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        return usuario.orElse(null);
    }

    // GUARDAR
    public Usuario guardarUsuario(Usuario usuario) {

        // Encriptar password
        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword())
        );

        return usuarioRepository.save(usuario);
    }

    // ACTUALIZAR
    public Usuario actualizarUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    // ELIMINAR
    public void eliminarUsuario(Integer id) {

        usuarioRepository.deleteById(id);
    }
}