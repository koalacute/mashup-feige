package com.xrikui.mashup.feige.service;

import cn.hutool.core.date.DateUtil;
import com.xrikui.mashup.common.utils.DateTimeUtils;
import com.xrikui.mashup.feige.entity.DataDetail;
import com.xrikui.mashup.feige.entity.Detail;
import com.xrikui.mashup.feige.entity.SendMessageRequestDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SendMessageService {

    private RestTemplate restTemplate = new RestTemplate();

    public void send(String stockName, BigDecimal currentPrice, BigDecimal nowRate, BigDecimal lastRate) {
        SendMessageRequestDto sendMessageRequestDto = new SendMessageRequestDto();
        sendMessageRequestDto.setSecret("9ec4e9dd4a2754039440919748a5b9d8");
        sendMessageRequestDto.setApp_key("c767b545a3875c29b1ea4e0386b9c928");
        sendMessageRequestDto.setTemplate_id("vZykWq7A36LwE4huJFPuUq42bkMZ0FWMl8-ghBu3CM4");

        Detail first = new Detail();
        first.setValue("当前价格:" + currentPrice + ",当前涨跌率:" + nowRate);
        first.setColor("#173177");

        Detail keyword1 = new Detail();
        keyword1.setValue(stockName);
        keyword1.setColor("#173177");

        Detail keyword2 = new Detail();
        keyword2.setValue(DateUtil.format(new Date(), DateTimeUtils.yyyyMMddHHmmss));
        keyword2.setColor("#173177");

        Detail remark = new Detail();
        remark.setValue("较上次记录涨跌浮:" + lastRate);
        remark.setColor("#173177");

        DataDetail dataDetail = new DataDetail();
        dataDetail.setFirst(first);
        dataDetail.setKeyword1(keyword1);
        dataDetail.setKeyword2(keyword2);
        dataDetail.setRemark(remark);
        sendMessageRequestDto.setData(dataDetail);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(sendMessageRequestDto, httpHeaders);

        restTemplate.postForEntity("http://u.ifeige.cn/api/message/send", httpEntity, String.class);
    }
}
