package com.aicards.entrypoint.http;

import com.aicards.dataprovider.model.User;
import com.aicards.dataprovider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/{userId}")
    public String findUserById(@PathVariable String userId){
        repository.findByUserId(userId);
        return "OK";
    }

    @PostMapping
    public User add(){
        return repository.save(new User("DAVID", "LUCAS", "1999", UUID.randomUUID().toString()));
    }

}
