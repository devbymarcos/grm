package com.devbymarcos.grm.modulos.User.dto;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginUserDTO {

    @Email(message = "Email deve ser válido")
    private String email;
    @Length(min = 6, message = "Password deve ter no mínimo 6 caracteres")
    private String password;

}
