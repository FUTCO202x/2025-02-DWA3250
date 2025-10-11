package com.example.kener.controller;

import com.example.kener.dto.NombreCompletoDTO;
import com.example.kener.dto.UsuarioCompleteDTO;
import com.example.kener.dto.UsuarioCreateDTO;
import com.example.kener.dto.UsuarioResponseDTO;
import com.example.kener.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Crear usuario - Retorna nombre y apellido en mayúsculas
    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioResponseDTO response = usuarioService.crearUsuario(usuarioCreateDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Obtener todos los usuarios
    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioCompleteDTO>> obtenerTodosLosUsuarios() {
        List<UsuarioCompleteDTO> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // Obtener usuario por id
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioCompleteDTO> obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint con parámetros en la URL
    @GetMapping("/params")
    public ResponseEntity<NombreCompletoDTO> obtenerNombreCompleto(
            @RequestParam String nombre,
            @RequestParam String apellido) {
        String nombreCompleto = nombre + " " + apellido;
        NombreCompletoDTO response = new NombreCompletoDTO(nombreCompleto);
        return ResponseEntity.ok(response);
    }
}

