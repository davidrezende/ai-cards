package com.aicards.usecase;

import com.aicards.dataprovider.UserDataProvider;
import com.aicards.entity.vo.SaveUserRequest;
import com.aicards.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserUseCase {

    private final UserDataProvider userDataProvider;

    public UserUseCase(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    public UserEntity findUserByUserId(String userId){
        return userDataProvider.findUserByUserId(userId);
    }

    public UserEntity saveUser(SaveUserRequest saveUserRequest){

        UserEntity userEntity = new UserEntity(
                saveUserRequest.getNome(),
                saveUserRequest.getSobrenome(),
                saveUserRequest.getIdade(),
                UUID.randomUUID().toString()
        );

        return userDataProvider.saveUser(userEntity);
    }
}
