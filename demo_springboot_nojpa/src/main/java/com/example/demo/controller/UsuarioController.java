package com.example.demo.controller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuarios")
    public UsuarioDTO crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevo = usuarioService.crearUsuario(usuario);
        return new UsuarioDTO(nuevo.getNombre(), nuevo.getApellido());
    }

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario obtenerPorId(@PathVariable int id) {
        return usuarioService.obtenerPorId(id);
    }

    @GetMapping("/params")
    public Map<String, String> obtenerNombreCompleto(
            @RequestParam String nombre,
            @RequestParam String apellido) {

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("nombreCompleto", nombre + " " + apellido);
        return respuesta;
    }
}
