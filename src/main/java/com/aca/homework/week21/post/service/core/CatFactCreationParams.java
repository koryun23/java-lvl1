package com.aca.homework.week21.post.service.core;

public class CatFactCreationParams {
    private String content;
    private int length;

    public CatFactCreationParams(String content, int length) {
        this.content = content;
        this.length = length;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
