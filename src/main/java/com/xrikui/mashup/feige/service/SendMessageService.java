package com.xrikui.mashup.feige.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SendMessageService {

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * 发送通知服务
     *
     * @param object
     * @param url
     */
    public void send(Object object, String url) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(object, httpHeaders);
        restTemplate.postForEntity(url, httpEntity, String.class);
    }
}
