package br.com.baseapp.controllers.api.v1;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequestMapping("/api/v1/users")
public class UserController {
    
    @Autowired
    private UsersRepository userRepository;

    @GetMapping("/")
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public User create(@RequestBody @Valid User u) {
        
        u.setPassword(
            (new BCryptPasswordEncoder()).encode(u.getPassword())
        );

        return userRepository.save(u);
    }

    @GetMapping("/{id}")
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

    @PutMapping("/{id}")
    public User edit(@RequestBody User u, @PathVariable("id") UUID id) {
        return userRepository.save(u);
    }

}
