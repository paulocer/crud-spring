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

import com.paulo.dto.EnderecoDTO;
import com.paulo.service.EnderecoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @GetMapping("/{id}")
    public EnderecoDTO findById(@PathVariable @NotNull @Positive Long id) {
        return enderecoService.findById(id);
    }

    @GetMapping("/login/{login}")
    public EnderecoDTO findByLogin(@PathVariable @NotNull String login) {
        return enderecoService.findByLogin(login);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EnderecoDTO create(@RequestBody @Valid @NotNull EnderecoDTO endereco) {
        return enderecoService.create(endereco);
    }

    @PutMapping("/{id}")
    public EnderecoDTO update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid @NotNull EnderecoDTO endereco) {
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        enderecoService.delete(id);
    }

}
