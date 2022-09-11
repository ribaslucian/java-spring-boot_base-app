package br.com.baseapp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.baseapp.models.User;
import br.com.baseapp.repositories.UsersRepository;

@RestController
@Controller
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UsersRepository userRepository;

    @GetMapping("/api")
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping("/api")
    public User create(@RequestBody User u) {
        return userRepository.save(u);
    }

    @GetMapping("/api/{id}")
    public User search(@PathVariable("id") UUID id) {
        Optional<User> u = userRepository.findById(id);

        if (u.isPresent())
            return u.get();

        return null;
    }

    // @GetMapping("/api/findAllMoreThan/{id}")
    // public List<User> findMoreThan(@PathVariable("id") UUID id) {
    //     return userRepository.findByIdGreaterThan(id);
    // }

    @PutMapping("/api/{id}")
    public User edit(@RequestBody User u, @PathVariable("id") UUID id) {
        return userRepository.save(u);
    }

}
