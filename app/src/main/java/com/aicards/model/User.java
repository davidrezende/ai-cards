package com.aicards.model;


import org.springframework.data.annotation.Id;

import java.util.UUID;

public class User {

    private String nome;
    private String sobrenome;
    private String idade;

    public User(String nome, String sobrenome, String idade){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }
}
