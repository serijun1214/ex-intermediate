package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Clothe;
import com.example.exintermediate.service.ClotheService;



@Controller
@RequestMapping("")
public class ClotheController {

  @Autowired
  private ClotheService clotheService;

  @GetMapping("/clotheSearch")
  public String clotheSearch(String gender, String color, Model model) {

    if (gender == null || color == null) {
      return "ex03/clothe-search";
    }

    List<Clothe> clotheList = clotheService.findByGenderAndColor(Integer.parseInt(gender), color);
    model.addAttribute("gender", gender);
    model.addAttribute("color", color);
    model.addAttribute("clotheList", clotheList);
    return "ex03/clothe-search";
  }
}
