package com.endava.demo.entity.createIssue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fields {
    private String[] labels;
    private Project project;
    private String summary;
    private IssueType issuetype;

}
