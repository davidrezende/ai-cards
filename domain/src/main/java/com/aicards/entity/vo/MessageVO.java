package com.aicards.entity.vo;

public class MessageVO {
    private String role;
    private String content;

    public MessageVO(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public MessageVO() {

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
