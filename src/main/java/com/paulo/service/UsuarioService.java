package com.paulo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.paulo.dto.UsuarioDTO;
import com.paulo.dto.mapper.UsuarioMapper;
import com.paulo.exception.RecordNotFoundException;
import com.paulo.exception.LoginNotFoundException;
import com.paulo.repository.UsuarioRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Autowired
    public List<UsuarioDTO> list() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO findById(@PathVariable @NotNull @Positive Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public UsuarioDTO findByLogin(@PathVariable @NotNull String login) {
        return usuarioRepository.findByLogin(login)
                .map(usuarioMapper::toDTO)
                .orElseThrow(() -> new LoginNotFoundException(login));
    }

    public UsuarioDTO create(@Valid @NotNull UsuarioDTO usuario) {
        if (usuario == null) {
            return null;
        }
        return usuarioMapper.toDTO(usuarioRepository.save(usuarioMapper.toEntity(usuario)));
    }

    public UsuarioDTO update(@Valid @NotNull @Positive Long id, @Valid @NotNull UsuarioDTO usuario) {
        return usuarioRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setLogin(usuario.login());
                    recordFound.setNome(usuario.nome());
                    recordFound.setEmail(usuario.email());
                    recordFound.setPerfil(usuario.perfil());
                    recordFound.setSenha(usuario.senha());
                    return usuarioMapper.toDTO(usuarioRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {

        usuarioRepository.delete(usuarioRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));

    }
}
