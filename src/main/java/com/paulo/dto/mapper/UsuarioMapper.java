package com.paulo.dto.mapper;

import org.springframework.stereotype.Component;

import com.paulo.dto.UsuarioDTO;
import com.paulo.model.Usuario;

@Component
public class UsuarioMapper {
    public UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getId(), usuario.getLogin(), usuario.getNome(), usuario.getEmail(),
                usuario.getPerfil(), usuario.getSenha());
    }

    public Usuario toEntity(UsuarioDTO usuarioDTO) {

        if (usuarioDTO == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        if (usuarioDTO.id() != null) {
            usuario.setId(usuarioDTO.id());
        }
        usuario.setLogin(usuarioDTO.login());
        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        usuario.setPerfil(usuarioDTO.perfil());
        usuario.setSenha(usuarioDTO.senha());
        return usuario;
    }

}
