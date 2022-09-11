package br.com.baseapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.baseapp.models.Hero;
import br.com.baseapp.repositories.HeroesRepository;

@RestController
@Controller
@RequestMapping("/heroes")
public class HeroesController {

    @Autowired
    private HeroesRepository heroesRepository;

    @GetMapping("/api")
    public List<Hero> list() {
        return heroesRepository.findAll();
    }

    @PostMapping("/api")
    public Hero create(@RequestBody Hero H) {
        return heroesRepository.save(H);
    }

    @GetMapping("/api/{id}")
    public Hero search(@PathVariable("id") Long id) {
        Optional<Hero> u = heroesRepository.findById(id);

        if (u.isPresent())
            return u.get();

        return null;
    }

    @PutMapping("/api/{id}")
    public Hero edit(@RequestBody Hero u, @PathVariable("id") Long id) {
        return heroesRepository.save(u);
    }

}
