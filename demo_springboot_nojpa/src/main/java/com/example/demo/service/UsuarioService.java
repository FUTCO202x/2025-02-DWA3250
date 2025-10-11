package com.example.demo.service;

import com.example.demo.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        usuarios.add(new Usuario(1, "Juan", "Perez", "juan@gmail.com"));
        usuarios.add(new Usuario(2, "Maria", "Lopez", "maria@gmail.com"));
        usuarios.add(new Usuario(3, "Carlos", "Gomez", "carlos@gmail.com"));
    }

    public Usuario crearUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public Usuario obtenerPorId(int id) {
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
