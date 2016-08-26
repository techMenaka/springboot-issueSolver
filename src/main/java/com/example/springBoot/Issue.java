package com.example.springBoot;

import org.springframework.social.github.api.GitHubUser;
/**
 * Created by Menaka on 8/17/16.
 */

public class Issue {

    private String repo;
    private GitHubUser gitHubIssue;

    public Issue(String repo, GitHubUser user) {
        this.repo = repo;
        this.gitHubIssue = user;
    }
}
