package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exintermediate.domain.Hotel;
import com.example.exintermediate.repository.HotelRepository;

/**
 * hotelsテーブルを操作するサービス
 */
@Service
public class HotelService {
  
  // HotelRepositoryをDI
  @Autowired
  private HotelRepository hotelRepository;

  /**
   * 全てのホテル情報を取得
   * 
   * @return ホテル情報のリスト
   */
  public List<Hotel> findByPrice(Integer price) {
    return hotelRepository.findByPrice(price);
  }
}
