package com.example.exintermediate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.service.TeamService;

@Controller
@RequestMapping("")
public class TeamController {

  @Autowired
  private TeamService teamService;

  @RequestMapping("/teamList")
  public String teams(Model model) {
    model.addAttribute("teamList", teamService.findAll());
    return "ex01/teamList";
  }
}