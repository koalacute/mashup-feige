package com.xrikui.mashup.feige.entity;

public class SendMessageRequestDto {

    private String secret;

    private String app_key;

    private String template_id;

    private DataDetail data;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public DataDetail getData() {
        return data;
    }

    public void setData(DataDetail data) {
        this.data = data;
    }
}
