package com.aicards.entrypoint.http;

import com.aicards.dataprovider.model.User;
import com.aicards.dataprovider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/{userId}")
    public String findUserById(){
        repository.save(new User("DAVID", "LUCAS", "19"));
        return "OK";
    }

    @PostMapping
    public String add(){
        repository.save(new User("DAVID", "LUCAS", "19"));
        return "OK";
    }

}
