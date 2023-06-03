package com.aicards.dataprovider.model;


import com.aicards.entity.UserEntity;

import java.time.LocalDate;

public class User {

    private String nome;
    private String sobrenome;
    private String idade;
    private String userId;
    private LocalDate datCreation;

    public User(String nome, String sobrenome, String idade, String userId, LocalDate datCreation) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.userId = userId;
        this.datCreation = datCreation;
    }

    public User(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getDatCreation() {
        return datCreation;
    }

    public void setDatCreation(LocalDate datCreation) {
        this.datCreation = datCreation;
    }

    public UserEntity toEntity(){
        return new UserEntity(
                this.nome,
                this.sobrenome,
                this.idade,
                this.userId,
                this.datCreation
        );
    }

    public User toUser(UserEntity entity){
        return new User(
                entity.getNome(),
                entity.getSobrenome(),
                entity.getIdade(),
                entity.getUserId(),
                entity.getDatCreation()
        );
    }
}
