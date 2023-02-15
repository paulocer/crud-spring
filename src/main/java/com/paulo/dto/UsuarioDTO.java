package com.paulo.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
                @JsonProperty("_id") Long id,
                @NotBlank @NotNull @Length(min = 5, max = 15) String login,
                @NotBlank @NotNull @Length(min = 5, max = 60) String nome,
                @NotBlank @NotNull @Email String email,
                @NotBlank @NotNull @Length(min = 5, max = 15) String perfil,
                @NotBlank @NotNull @Length(min = 8, max = 16) String senha) {

}
