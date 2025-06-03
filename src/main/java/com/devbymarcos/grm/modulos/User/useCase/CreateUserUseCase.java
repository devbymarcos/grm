package com.devbymarcos.grm.modulos.User.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devbymarcos.grm.exeception.UserFoundException;
import com.devbymarcos.grm.modulos.User.entities.UserEntity;
import com.devbymarcos.grm.modulos.User.repositories.UserRepository;

@Service
public class CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    public UserEntity execute(UserEntity userEntity) {
        this.userRepository.findByEmail(userEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });
        return this.userRepository.save(userEntity);
    }
}
