package com.paulo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.paulo.dto.EnderecoDTO;
import com.paulo.dto.mapper.EnderecoMapper;
import com.paulo.exception.RecordNotFoundException;
import com.paulo.exception.LoginNotFoundException;
import com.paulo.repository.EnderecoRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoMapper enderecoMapper;

    public EnderecoService(EnderecoRepository enderecoRepository, EnderecoMapper enderecoMapper) {
        this.enderecoRepository = enderecoRepository;
        this.enderecoMapper = enderecoMapper;
    }

    @Autowired
    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll()
                .stream()
                .map(enderecoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EnderecoDTO findById(@PathVariable @NotNull @Positive Long id) {
        return enderecoRepository.findById(id)
                .map(enderecoMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public EnderecoDTO findByLogin(@PathVariable @NotNull String login) {
        return enderecoRepository.findByLogin(login)
                .map(enderecoMapper::toDTO)
                .orElseThrow(() -> new LoginNotFoundException(login));
    }

    public EnderecoDTO create(@Valid @NotNull EnderecoDTO endereco) {
        if (endereco == null) {
            return null;
        }
        return enderecoMapper.toDTO(enderecoRepository.save(enderecoMapper.toEntity(endereco)));
    }

    public EnderecoDTO update(@Valid @NotNull @Positive Long id, @Valid @NotNull EnderecoDTO endereco) {
        return enderecoRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setLogin(endereco.login());
                    recordFound.setLogradouro(endereco.logradouro());
                    recordFound.setNumero(endereco.numero());
                    recordFound.setComplemento(endereco.complemento());
                    recordFound.setBairro(endereco.bairro());
                    recordFound.setCep(endereco.cep());
                    recordFound.setCidade(endereco.cidade());
                    recordFound.setUf(endereco.uf());
                    return enderecoMapper.toDTO(enderecoRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {

        enderecoRepository.delete(enderecoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));

    }
}
