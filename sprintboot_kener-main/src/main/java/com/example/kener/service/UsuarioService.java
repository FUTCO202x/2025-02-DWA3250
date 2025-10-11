package com.example.kener.service;

import com.example.kener.dto.UsuarioCompleteDTO;
import com.example.kener.dto.UsuarioCreateDTO;
import com.example.kener.dto.UsuarioResponseDTO;
import com.example.kener.model.Usuario;
import com.example.kener.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Crear usuario y retornar nombre y apellido en mayúsculas
    public UsuarioResponseDTO crearUsuario(UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario(dto.getNombre(), dto.getApellido(), dto.getEmail());
        usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(
            usuario.getNombre().toUpperCase(),
            usuario.getApellido().toUpperCase()
        );
    }

    // Obtener todos los usuarios
    public List<UsuarioCompleteDTO> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll().stream()
            .map(usuario -> new UsuarioCompleteDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail()
            ))
            .collect(Collectors.toList());
    }

    // Obtener usuario por id
    public Optional<UsuarioCompleteDTO> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
            .map(usuario -> new UsuarioCompleteDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail()
            ));
    }
}

