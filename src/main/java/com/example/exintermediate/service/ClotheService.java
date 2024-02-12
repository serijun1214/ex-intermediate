package com.example.exintermediate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exintermediate.domain.Clothe;
import com.example.exintermediate.repository.ClotheRepository;

/**
 * 衣類情報を操作するサービス
 */
@Service
public class ClotheService {

  @Autowired
  private ClotheRepository clotheRepository;

  /**
   * 衣類情報を検索
   * 
   * @param gender 性別
   * @param color  色
   * @return 衣類情報
   */

  public List<Clothe> findByGenderAndColor(Integer gender, String color) {
    return clotheRepository.findByGenderAndColor(gender, color);
  }
}
