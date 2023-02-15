package com.paulo.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Endereco {

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
    @Length(max = 45)
    @Column(length = 45, nullable = false)
    private String logradouro;

    @NotBlank
    @NotNull
    @Length(max = 15)
    @Column(length = 45, nullable = false)
    private String numero;

    @Length(max = 45)
    @Column(length = 45, nullable = false)
    private String complemento;

    @NotBlank
    @NotNull
    @Length(max = 45)
    @Column(length = 45, nullable = false)
    private String bairro;

    @NotBlank
    @NotNull
    @Length(min = 8, max = 10)
    @Column(length = 10, nullable = false)
    private String cep;

    @NotBlank
    @NotNull
    @Length(max = 45)
    @Column(length = 45, nullable = false)
    private String cidade;

    @NotBlank
    @NotNull
    @Length(min = 2, max = 2)
    @Column(length = 2, nullable = false)
    private String uf;

}
