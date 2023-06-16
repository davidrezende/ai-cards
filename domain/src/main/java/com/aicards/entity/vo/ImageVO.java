package com.aicards.entity.vo;

public class ImageVO {
    private String idReplicate;
    private String created_at;
    private String started_at;
    private String completed_at;
    private String prompt;
    private String image;

    public ImageVO(String idReplicate, String created_at, String started_at, String completed_at, String prompt, String image) {
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(String completed_at) {
        this.completed_at = completed_at;
    }
}
