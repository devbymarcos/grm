package com.devbymarcos.grm.exeception;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("usuário ja existe");
    }
}
