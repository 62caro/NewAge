package com.caro.newage.controller;

import com.caro.newage.entity.Ruler;
import com.caro.newage.repo.RulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    RulerRepository rulerRepository;

    @GetMapping("/")
    public String mainPage(Model model){
        Iterable<Ruler> rulers = rulerRepository.findAllByAge(PageRequest.of(0, 10));
        model.addAttribute("rulers", rulers);
        Iterable<Ruler> lazyRuler = rulerRepository.findRulersWithoutPlanet();
        model.addAttribute("lazyRulers", lazyRuler);
        return "main";
    }

    @Autowired
    public void setRulerRepository(RulerRepository rulerRepository) {
        this.rulerRepository = rulerRepository;
    }
}
