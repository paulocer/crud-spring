package com.paulo.exception;

public class LoginNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LoginNotFoundException(String login) {
        super("Registro não encontrado com o usuário: " + login);
    }
}
