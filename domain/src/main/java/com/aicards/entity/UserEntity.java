package com.aicards.entity;

import java.time.LocalDate;

public class UserEntity {

    private String nome ;
    private String sobrenome;
    private String idade;
    private String userId;
    private LocalDate datCreation;

    public UserEntity(String nome, String sobrenome, String idade, String userId, LocalDate datCreation) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.userId = userId;
        this.datCreation = datCreation;
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
}
