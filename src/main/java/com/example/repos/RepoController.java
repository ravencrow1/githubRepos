package com.example.repos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RepoController {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{username}")
    public ResponseEntity<?> getRepos(@PathVariable String username) {
        List<RepoWithUrl> repoWithUrlList;
        try {
            repoWithUrlList = getUserRepos(username);
        } catch (HttpClientErrorException.NotFound e) {
            Map<String, Object> error = new HashMap<>();
            error.put("status", 404);
            error.put("message", "User not found: " + username);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        ArrayList<Repo> result = new ArrayList<>();
        for (RepoWithUrl repo : repoWithUrlList) {
            String repoName = repo.getRepoName();
            String ownerLogin = repo.getOwnerLogin();
            List<Branch> branches = getUserBranch(repo.getBranchUrl());
            result.add(new Repo(repoName, ownerLogin, branches));
        }
        return ResponseEntity.ok(result);
    }

    public List<RepoWithUrl> getUserRepos(String username) {
        String url = "https://api.github.com/users/" + username + "/repos";
        List<Map<String, Object>> repos = restTemplate.getForObject(url, List.class);
        List<RepoWithUrl> result = new ArrayList<>();
        for (Map<String, Object> repo : repos) {
            Boolean fork = (Boolean)repo.get("fork");
            if (fork != null && !fork) {
                String repoName = (String)repo.get("name");
                Map<String, Object> owner = (Map<String, Object>)repo.get("owner");
                String ownerLogin = (String)owner.get("login");
                String branchUrl = ((String)repo.get("branches_url")).replace("{/branch}", "");
                result.add(new RepoWithUrl(repoName, ownerLogin, branchUrl));
            }
        }
        return result;
    }

    public List<Branch> getUserBranch(String branchUrl) {
        List<Map<String, Object>> branches = restTemplate.getForObject(branchUrl, List.class);
        List<Branch> result = new ArrayList<>();
        for (Map<String, Object> branch : branches) {
            String branchName = (String)branch.get("name");
            Map<String, Object> commit = (Map<String, Object>)branch.get("commit");
            String lastCommitSha = (String)commit.get("sha");
            result.add(new Branch(branchName, lastCommitSha));
        }
        return result;
    }
}
