package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.domain.Clothe;


/**
 * clothesテーブルを操作するリポジトリ
 */
@Repository
public class ClotheRepository {

  // NamedParameterJdbcTemplateをDI
  @Autowired
  NamedParameterJdbcTemplate template;;

  // RowMapper
  private static final RowMapper<Clothe> CLOTHE_ROW_MAPPER = (rs, i) -> {
    Clothe clothe = new Clothe();
    clothe.setId(rs.getInt("id"));
    clothe.setCategory(rs.getString("category"));
    clothe.setGenre(rs.getString("genre"));
    clothe.setGender(rs.getInt("gender"));
    clothe.setColor(rs.getString("color"));
    clothe.setPrice(rs.getInt("price"));
    clothe.setSize(rs.getString("size"));
    return clothe;
  };

  /**
   * 衣類情報を検索
   * 
   * @param gender 性別
   * @param color  色
   * @return 衣類情報
   */

  public List<Clothe> findByGenderAndColor(Integer gender, String color) {
    String sql = "SELECT id,category,genre,gender,color,price,size FROM clothes WHERE gender = :gender AND color = :color";
    SqlParameterSource param = new MapSqlParameterSource()
    .addValue("gender", gender)
    .addValue("color", color);
    List<Clothe> clotheList = template.query(sql, param, CLOTHE_ROW_MAPPER);

    if(clotheList.size() == 0) {
      return null;
    }

    return clotheList;
  }
}
