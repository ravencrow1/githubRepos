package com.example.repos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepoController {
    @GetMapping("/")
    public Repo getRepo() {
        return new Repo("repo name", "owner login");
    }
}
