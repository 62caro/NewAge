package com.caro.newage.controller;

import com.caro.newage.entity.Ruler;
import com.caro.newage.repo.RulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RulerController {

    RulerRepository rulerRepository;

    @GetMapping("/ruler")
    public String ruler(Model model){
        Iterable<Ruler> rulers = rulerRepository.findAll();
        model.addAttribute("rulers", rulers);

        return "ruler";
    }

    @GetMapping("/ruler/rulerAdd")
    public String rulerAdd(Model model){
        return "rulerAdd";
    }

    @PostMapping("/ruler/rulerAdd")
    public String newRulerAdd(Model model,
                           @RequestParam("name") String name, @RequestParam("age") int age){
        Ruler ruler = new Ruler(name, age);

        rulerRepository.save(ruler);
        return "redirect:/ruler";
    }

    @Autowired
    public void setRulerRepository(RulerRepository rulerRepository) {
        this.rulerRepository = rulerRepository;
    }
}
