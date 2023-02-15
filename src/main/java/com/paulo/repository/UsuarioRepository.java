package com.paulo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
}
