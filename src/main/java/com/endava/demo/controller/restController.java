package com.endava.demo.controller;

import com.endava.demo.entity.Issue;
import com.endava.demo.entity.Session;
import com.endava.demo.service.Authorization;
import com.endava.demo.service.impl.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class restController {
    @Autowired
    IssueService service;

    @Autowired
    Authorization authorization;

    Session session ;


    @GetMapping("/test")
    public void getTest() {

        session = authorization.auth();
    }

    @GetMapping("/getIssue/{id}")
    public ResponseEntity<?> getIssueById(@PathVariable String id) {

        return service.getIssueById(session.getValue(),id);
    }

    @PostMapping("/createIssue")
    public ResponseEntity<?> createIssue(@RequestBody Issue issue)
    {

        return service.createIssue(session.getValue(),issue);
    }

    @PutMapping("/updateIssue/{id}")
    public void updateIssue(@RequestBody Issue issue, @PathVariable String id)
    {

        service.updateIssue(session.getValue(), issue, id); }

        @GetMapping("/search/{assignee}")
    public ResponseEntity searchByAssignee(@PathVariable String assignee)
        {
            return service.search( session.getValue(),assignee);
        }

}
