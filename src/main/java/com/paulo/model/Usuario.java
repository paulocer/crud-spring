package com.paulo.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 15)
    @Column(length = 15, nullable = false)
    private String login;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 60)
    @Column(length = 60, nullable = false)
    private String nome;

    @NotBlank
    @NotNull
    @Email
    @Column(length = 30, nullable = false)
    private String email;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 15)
    @Column(length = 15, nullable = false)
    private String perfil;

    @NotBlank
    @NotNull
    @Length(min = 8, max = 16)
    @Column(length = 32, nullable = false)
    private String senha;
}
