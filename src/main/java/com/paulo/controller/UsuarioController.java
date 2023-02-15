package com.paulo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.dto.UsuarioDTO;
import com.paulo.service.UsuarioService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDTO> list() {
        return usuarioService.list();
    }

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable @NotNull @Positive Long id) {
        return usuarioService.findById(id);
    }

    @GetMapping("/login/{login}")
    public UsuarioDTO findByLogin(@PathVariable @NotNull String login) {
        return usuarioService.findByLogin(login);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsuarioDTO create(@RequestBody @Valid @NotNull UsuarioDTO usuario) {
        return usuarioService.create(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid @NotNull UsuarioDTO usuario) {
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        usuarioService.delete(id);
    }

}
