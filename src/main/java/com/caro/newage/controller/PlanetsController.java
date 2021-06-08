package com.caro.newage.controller;

import com.caro.newage.entity.Planet;
import com.caro.newage.entity.Ruler;
import com.caro.newage.repo.PlanetRepository;
import com.caro.newage.repo.RulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class PlanetsController {

    PlanetRepository planetRepository;
    RulerRepository rulerRepository;

    @GetMapping("/planet")
    public String planet(Model model) {
        Iterable<Planet> planets = planetRepository.findAll();
        model.addAttribute("planets", planets);
        return "planet";
    }

    @GetMapping("/planet/planetAdd")
    public String planetAdd(Model model) {
        List<Ruler> ruler = new ArrayList<>();
        model.addAttribute("ruler", ruler);
        List<Ruler> rulers = rulerRepository.findAll();
        model.addAttribute("rulers", rulers);
        return "planetAdd";
    }

    @PostMapping("/planet/planetAdd")
    public String newPlanetAdd(@RequestParam("name") String name,
                               @RequestParam(value = "rulerPlanet", required = false) String ruler) {

        Ruler findRuler = rulerRepository.findByName(ruler);
        Planet planet = new Planet(name, findRuler);
        Set<Planet> getPlanet = findRuler.getPlanet();
        getPlanet.add(planet);
        findRuler.setPlanet(getPlanet);
        planetRepository.save(planet);
        rulerRepository.save(findRuler);

        return "redirect:/planet";
    }

    @GetMapping("/planet/{id}/delete")
    public String blogDetailsDelete(@PathVariable(value = "id") long id, Model model) {
        if (!planetRepository.existsById(id)) {
            return "redirect:/planet";
        }
        Planet post = planetRepository.findById(id).orElseThrow();
        planetRepository.delete(post);
        return "redirect:/planet";
    }

    @Autowired
    public void setRulerRepository(RulerRepository rulerRepository) {
        this.rulerRepository = rulerRepository;
    }

    @Autowired
    public void setPlanetRepository(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }
}
