package com.example.repos;

public class Repo {
    private String repoName;
    private String ownerLogin;

    public Repo(String repoName, String ownerLogin) {
        this.repoName = repoName;
        this.ownerLogin = ownerLogin;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }
}
