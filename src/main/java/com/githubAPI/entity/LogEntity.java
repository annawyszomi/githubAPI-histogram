package com.githubAPI.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "login")
@RequiredArgsConstructor
public class LogEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String login;
  private String message;
  private Timestamp timestamp;

}
