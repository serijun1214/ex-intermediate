package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exintermediate.domain.Team;
import com.example.exintermediate.repository.TeamRepository;


/**
 * teamsテーブルを操作するサービス
 */
@Service
public class TeamService {

  // TeamRepositoryをDI
  @Autowired
  private TeamRepository teamRepository;

  // 全てのチーム情報を取得
  public List<Team> findAll() {
    return teamRepository.findAll();
  }
}
