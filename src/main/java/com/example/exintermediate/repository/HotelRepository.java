package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.domain.Hotel;
import com.example.exintermediate.domain.Team;

/**
 * hotelsテーブルを操作するリポジトリ
 */
@Repository
public class HotelRepository {
  
    // NamedParameterJdbcTemplateをDI
  @Autowired
  NamedParameterJdbcTemplate template;;

  // RowMapper
  private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
    Hotel hotel = new Hotel();
    hotel.setId(rs.getInt("id"));
    hotel.setAreaName(rs.getString("area_name"));
    hotel.setHotelName(rs.getString("hotel_name"));
    hotel.setAddress(rs.getString("address"));
    hotel.setNearestStation(rs.getString("nearest_station"));
    hotel.setPrice(rs.getInt("price"));
    hotel.setParking(rs.getString("parking"));
    return hotel;
  };

  /**
   * 全てのホテル情報を取得
   * 
   * @return ホテル情報のリスト
   */
  public List<Hotel> findByPrice(Integer price) {

    List<Hotel> hotelList = null;

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels ");

    if(price != null) {
      sql.append("WHERE price <= :price ORDER BY price");
      hotelList = template.query(sql.toString(), new MapSqlParameterSource().addValue("price", price), HOTEL_ROW_MAPPER);
    } else {
      sql.append("ORDER BY price");
      hotelList = template.query(sql.toString(), HOTEL_ROW_MAPPER);
    }

    if(hotelList.size() == 0) {
      return null;
    }
    
    return hotelList;
  }
}
