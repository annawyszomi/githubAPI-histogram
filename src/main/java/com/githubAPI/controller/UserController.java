package com.githubAPI.controller;

import com.githubAPI.service.HistogramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final HistogramService service;


    @GetMapping("/users/{login}/reposHistogram")
    @ResponseBody
    @Transactional
    public ResponseEntity<Map<Integer, String>> getReposHistogram(@PathVariable String login) {
        var histogram = service.getHistogramRepos(login);

        return ResponseEntity.ok(histogram);
    }

    @GetMapping("/users/{login}/repos")
    @ResponseBody
    @Transactional
    public ResponseEntity<Map<Integer, String>> getUsersRepos(@PathVariable String login) {
        var repos = service.getUserRepo(login);

        return ResponseEntity.ok(repos);
    }

}
