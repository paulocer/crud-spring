package com.paulo.dto.mapper;

import org.springframework.stereotype.Component;

import com.paulo.dto.EnderecoDTO;
import com.paulo.model.Endereco;

@Component
public class EnderecoMapper {
    public EnderecoDTO toDTO(Endereco endereco) {
        return new EnderecoDTO(endereco.getId(), endereco.getLogin(), endereco.getLogradouro(), endereco.getNumero(),
                endereco.getComplemento(), endereco.getBairro(), endereco.getCep(), endereco.getCidade(),
                endereco.getUf());
    }

    public Endereco toEntity(EnderecoDTO enderecoDTO) {

        if (enderecoDTO == null) {
            return null;
        }

        Endereco endereco = new Endereco();
        if (enderecoDTO.id() != null) {
            endereco.setId(enderecoDTO.id());
        }
        endereco.setLogin(enderecoDTO.login());
        endereco.setLogradouro(enderecoDTO.logradouro());
        endereco.setNumero(enderecoDTO.numero());
        endereco.setComplemento(enderecoDTO.complemento());
        endereco.setBairro(enderecoDTO.bairro());
        endereco.setCep(enderecoDTO.cep());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setUf(enderecoDTO.uf());
        return endereco;
    }

}
