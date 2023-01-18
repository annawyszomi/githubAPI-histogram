package com.githubAPI.repository;

import com.githubAPI.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogRepository extends JpaRepository<LogEntity, Integer> {
}
