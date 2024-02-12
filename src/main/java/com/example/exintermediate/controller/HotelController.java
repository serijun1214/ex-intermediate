package com.example.exintermediate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.service.HotelService;



@Controller
@RequestMapping("")
public class HotelController {

  @Autowired
  private HotelService hotelService;

  @GetMapping("/showHotelList")
  public String showHotelList() {
    return "ex02/hotel-search";
  }

  @GetMapping("/hotelSearch")
  public String hotelSearch(Integer price, Model model){
    model.addAttribute("hotelList", hotelService.findByPrice(price));
    model.addAttribute("price", price);
    return "ex02/hotel-search";
  }
}
