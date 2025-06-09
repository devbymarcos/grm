package com.devbymarcos.grm.modulos.User.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.devbymarcos.grm.exeception.UserFoundException;
import com.devbymarcos.grm.modulos.User.entities.UserEntity;
import com.devbymarcos.grm.modulos.User.repositories.UserRepository;

@Service
public class CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity execute(UserEntity userEntity) {
        this.userRepository.findByEmail(userEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });
        var password = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(password);
        return this.userRepository.save(userEntity);
    }
}
