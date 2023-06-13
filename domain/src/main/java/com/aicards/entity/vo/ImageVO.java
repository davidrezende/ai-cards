package com.aicards.entity.vo;

public class ImageVO {
    private String idReplicate;
    private String image;
    private String prompt;

    public ImageVO(String idReplicate, String image, String prompt) {
        this.idReplicate = idReplicate;
        this.image = image;
        this.prompt = prompt;
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
}
