package com.paulo.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 5, max = 15) String login,
        @NotBlank @NotNull @Length(min = 1, max = 45) String logradouro,
        @NotBlank @NotNull @Length(min = 1, max = 15) String numero,
        @NotBlank @Length(min = 1, max = 15) String complemento,
        @NotBlank @NotNull @Length(min = 1, max = 45) String bairro,
        @NotBlank @NotNull @Length(min = 5, max = 10) String cep,
        @NotBlank @NotNull @Length(min = 3, max = 45) String cidade,
        @NotBlank @NotNull @Length(min = 2, max = 2) String uf) {

}
