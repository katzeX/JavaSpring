package com.endava.demo.service.impl;

import com.endava.demo.entity.Issue;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class IssueService {

    RestTemplate template = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    RestTemplate restTemplate = new RestTemplate();
    Map<String, String> body = new HashMap<>();





    public ResponseEntity<?> getIssueById(String sessionId, String idIssue){

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cookie", "JSESSIONID=" + sessionId);
        Map<String, String> body = new HashMap<>();
        HttpEntity request = new HttpEntity<>(body,headers);
        Object a =  template.exchange("https://uatjira.endava.com/rest/api/2/issue/" + idIssue, HttpMethod.GET, request, Object.class );
        System.out.println(a);
        return new ResponseEntity<>(a, HttpStatus.OK);

    }

    public ResponseEntity<?> createIssue(String sessionId, Issue issue)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cookie", "JSESSIONID=" + sessionId);

        HttpEntity request = new HttpEntity<>(issue, headers);
        Object test = restTemplate.postForObject("https://uatjira.endava.com/rest/api/2/issue", request, Object.class);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }


    public void updateIssue(String sessionId, Issue issue, String issueId)
    {
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cookie", "JSESSIONID=" + sessionId);
        HttpEntity request = new HttpEntity<>(issue, headers);
        restTemplate.exchange("https://uatjira.endava.com/rest/api/2/issue/" + issueId , HttpMethod.PUT, request, Issue.class );

    }

    public ResponseEntity<?> search(String sessionId, String assignee )
    {
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cookie", "JSESSIONID=" + sessionId);
        HttpEntity request = new HttpEntity<>(headers);
       Object a =  restTemplate.exchange("https://uatjira.endava.com/rest/api/2/search?jql=project=\"IIA\"AND assignee =" + "\"" + assignee + "\"AND createdDate>=startOfDay()",  HttpMethod.GET, request, String.class );
      return  new ResponseEntity<>(a, HttpStatus.OK);

    }
}
