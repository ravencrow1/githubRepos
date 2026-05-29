package com.example.repos;

public class RepoWithUrl {
    private String repoName;
    private String ownerLogin;
    private String branchUrl;

    public RepoWithUrl(String repoName, String ownerLogin, String branchUrl) {
        this.repoName = repoName;
        this.ownerLogin = ownerLogin;
        this.branchUrl = branchUrl;
    }

    public String getRepoName() {return repoName;}
    public String getOwnerLogin() {return ownerLogin;}
    public String getBranchUrl() {return branchUrl;}
}
