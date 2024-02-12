package com.example.exintermediate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Hotel;
import com.example.exintermediate.service.HotelService;

@Controller
@RequestMapping("")
public class HotelController {

  @Autowired
  private HotelService hotelService;

  @GetMapping("/hotelSearch")
  public String hotelSearch(String price, Model model) {

    List<Hotel> hotelList = null;

    if (price == null) {
      return "ex02/hotel-search";
    }
    if (price.isEmpty()) {
      hotelList = hotelService.findByPrice(null); // 全件検索
    } else {
      hotelList = hotelService.findByPrice(Integer.parseInt(price));
    }

    model.addAttribute("hotelList", hotelList);
    model.addAttribute("price", price);
    return "ex02/hotel-search";
  }
}
