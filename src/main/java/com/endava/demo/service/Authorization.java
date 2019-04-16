package com.endava.demo.service;

import com.endava.demo.entity.Session;
import com.endava.demo.entity.SessionObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class Authorization {


    @Value("${auth.username}")
    private String username ;
    @Value("${auth.password}")
    private  String password;

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    Session session;

    public Session auth()
    {
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap<>();

        body.put("username",username);
        body.put("password", password);

        HttpEntity request = new HttpEntity<>(body,headers);

        SessionObject obj =  restTemplate.postForObject("https://uatjira.endava.com/rest/auth/1/session", request, SessionObject.class );

        session = obj.getSession();
        return session;
    }

    }




