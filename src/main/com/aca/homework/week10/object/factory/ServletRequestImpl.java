package com.aca.homework.week10.object.factory;

public class ServletRequestImpl implements ServletRequest{
    private int contentLength;
    private String body;

    @Override
    public int getContentLength() {
        return contentLength;
    }

    @Override
    public String getBody() {
        return body;
    }

    public void setContentLength(int contentLength){
        if (contentLength < 0)
            throw new IllegalArgumentException("Content length must be a positive number");
        this.contentLength = contentLength;
    }

    public void setBody(String body){
        this.body = body;
    }
}
