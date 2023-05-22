package com.aicards.dataprovider;

import com.aicards.dataprovider.model.User;
import com.aicards.dataprovider.repository.UserRepository;
import com.aicards.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMongoProvider implements UserDataProvider{

    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity findUserByUserId(String userId) {
        return repository.findByUserId(userId).toEntity();
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return repository.save(new User().toUser(userEntity)).toEntity();
    }
}
