package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.domain.Team;

/**
 * teamsテーブルを操作するリポジトリ
 */
@Repository
public class TeamRepository {

  // NamedParameterJdbcTemplateをDI
  @Autowired
  NamedParameterJdbcTemplate template;

  // RowMapper
  private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
    Team team = new Team();
    team.setId(rs.getInt("id"));
    team.setLeagueName(rs.getString("league_name"));
    team.setTeamName(rs.getString("team_name"));
    team.setHeadquarters(rs.getString("headquarters"));
    team.setInauguration(rs.getString("inauguration"));
    team.setHistory(rs.getString("history"));
    return team;
  };

  /**
   * 全てのチーム情報を取得
   * 
   * @return チーム情報のリスト
   */
  public List<Team> findAll() {
    String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration";
    List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
    return teamList;
  }
}
