package com.aicards.usecase;

import com.aicards.dataprovider.UserDataProvider;
import com.aicards.entity.UserEntity;
import com.aicards.entity.vo.SaveUserRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SaveUserUseCase {

    private final UserDataProvider userDataProvider;

    public SaveUserUseCase(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    public UserEntity findUserByUserId(String userId) {
            return userDataProvider.findUserByUserId(userId);
    }

    public UserEntity saveUser(SaveUserRequest saveUserRequest) {

        UserEntity userEntity = new UserEntity(
                saveUserRequest.getNome(),
                saveUserRequest.getSobrenome(),
                saveUserRequest.getIdade(),
                UUID.randomUUID().toString()
        );

        return userDataProvider.saveUser(userEntity);
    }
}
