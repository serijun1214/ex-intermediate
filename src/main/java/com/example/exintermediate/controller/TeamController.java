package com.example.exintermediate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.exintermediate.domain.Team;
import com.example.exintermediate.service.TeamService;

@Controller
@RequestMapping("")
public class TeamController {

  @Autowired
  private TeamService teamService;

  @GetMapping("/teamList")
  public String teams(Model model) {
    model.addAttribute("teamList", teamService.findAll());
    return "ex01/team-list";
  }

  @GetMapping("/teamDetail")
  public String teamDetail(@RequestParam("id") Integer id, Model model) {
    Team team = teamService.load(id);
    team.setHistory(team.getHistory().replace("↓", "<br>↓<br>"));
    model.addAttribute("team", team);
    return "ex01/team-detail";
  }
}
