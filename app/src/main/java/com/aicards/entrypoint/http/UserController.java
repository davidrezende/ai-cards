package com.aicards.entrypoint.http;

import com.aicards.entity.vo.SaveUserRequest;
import com.aicards.entity.UserEntity;
import com.aicards.usecase.SaveUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private SaveUserUseCase userUseCase;

    @GetMapping("/{userId}")
    public UserEntity findUserById(@PathVariable String userId) {
        return userUseCase.findUserByUserId(userId);
    }

    @PostMapping
    public UserEntity add(@RequestBody SaveUserRequest saveUserRequest) {
        return userUseCase.saveUser(saveUserRequest);
    }

}
