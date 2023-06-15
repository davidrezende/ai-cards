package com.aicards.entity.vo;

import java.time.Instant;

public class ImageVO {
    private String idReplicate;
    private Instant created_at;
    private Instant started_at;
    private Instant completed_at;
    private String prompt;
    private String image;

    public ImageVO(String idReplicate, Instant created_at, Instant started_at, Instant completed_at, String prompt, String image) {
        this.idReplicate = idReplicate;
        this.created_at = created_at;
        this.started_at = started_at;
        this.completed_at = completed_at;
        this.prompt = prompt;
        this.image = image;
    }

    public String getIdReplicate() {
        return idReplicate;
    }

    public void setIdReplicate(String idReplicate) {
        this.idReplicate = idReplicate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Instant getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Instant started_at) {
        this.started_at = started_at;
    }

    public Instant getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(Instant completed_at) {
        this.completed_at = completed_at;
    }
}
