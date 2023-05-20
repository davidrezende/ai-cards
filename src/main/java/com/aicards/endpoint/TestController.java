package com.aicards.endpoint;

import com.aicards.model.User;
import com.aicards.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class TestController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/sekai")
    public String sekai(){
        repository.save(new User("DAVID", "LUCAS", "19"));
        return "OK";
    }

}
