package com.sms.sendsms.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.sendsms.dto.SmsResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class MessageReceiver implements IMessageReceiver{
    private final RestTemplate restTemplate=new RestTemplate();
    private final ObjectMapper mapper=new ObjectMapper();

    @Value("${africastalking.username}")
    private String username;

    @Value("${africastalking.apiKey}")
    private String apiKey;


    @SneakyThrows
    @Override
    public SmsResponse sendSms() {

        HttpHeaders headers=new HttpHeaders();
        headers.setBasicAuth(username,apiKey);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String>map=new LinkedMultiValueMap<>();
        map.add("message","make sure this message reaches you");
        map.add("phoneNumber","+254708110517");
        map.add("from","3600");


        String url="https://api.sandbox.africastalking.com/version1/messaging";
        UriComponents builder= UriComponentsBuilder.fromHttpUrl(url).build();
        HttpEntity<MultiValueMap> smsEntity=new HttpEntity<>(map,headers);

        ResponseEntity<JsonNode>response=restTemplate.exchange(
                builder.toString(),
                HttpMethod.POST,
                smsEntity,
                JsonNode.class);

        log.info("sms response {}",response.getBody());

        JsonNode responseBody=response.getBody();
        SmsResponse smsResponse=mapper.treeToValue(responseBody, SmsResponse.class);

        return smsResponse;
    }
}
