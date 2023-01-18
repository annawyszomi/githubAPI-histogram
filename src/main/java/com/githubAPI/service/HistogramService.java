package com.githubAPI.service;

import com.githubAPI.domain.UsersRepos;
import com.githubAPI.entity.LogEntity;
import com.githubAPI.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
@RequiredArgsConstructor
public class HistogramService {
    private final LogRepository repository;
    private final ApiResponder responder;

    public Map<Integer, String> getHistogramRepos(String login) {
        List<Integer> reposLength = new ArrayList<>();

        Map<Integer,String> result = new HashMap<>();

        var list = getUserRepoList(login);
        updateDatabase(login);

        for (UsersRepos repo : list) {
            reposLength.add(repo.getName().length());
        }
        for (var range = 0; range < reposLength.size(); range++) {
            result.put(range,convertToStars(reposLength.get(range)));

        }
        return result;

    }

    public Map<Integer, String> getUserRepo(String login) {
        var list = getUserRepoList(login);
        Map<Integer,String> result = new HashMap<>();
        for (var range = 0; range < list.length; range++) {
            result.put(range, list[range].getName());
        }
        return result;
    }

    private UsersRepos[] getUserRepoList(String login){
        return  responder.getUsersRepos(login);
    }

    private LogEntity updateDatabase(String login) {
        String message = "request was send";
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        LogEntity loginEntity = new LogEntity();
        loginEntity.setLogin(login);
        loginEntity.setTimestamp(timestamp);
        loginEntity.setMessage(message);

        return repository.save(loginEntity);
    }

    private String convertToStars(int num) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < num; j++) {
            builder.append('*');
        }
        return builder.toString();
    }
}
