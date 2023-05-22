package com.aicards.dataprovider;

import com.aicards.entity.UserEntity;

public interface UserDataProvider {
    UserEntity findUserByUserId(String userId);
    UserEntity saveUser(UserEntity user);
}
