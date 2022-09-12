package br.com.baseapp.controllers.api.v1;

import br.com.baseapp.dtos.users.UserCreateDto;
import br.com.baseapp.models.User;
import br.com.baseapp.repositories.UsersRepository;
import br.com.baseapp.services.UsersService;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

  private UsersRepository userRepository;
  private UsersService userService;
  private ModelMapper modelMapper;

  // @GetMapping("/")
  // public List<User> list() {
  //     return userService.listAll();
  // }

  @GetMapping("/")
  public ResponseEntity<List<User>> list() {
    // return userService.listAll();
    //
    //
    return ResponseEntity.ok(userService.listAll());
  }




  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public User create(@RequestBody @Valid UserCreateDto userDto) {
    // convert DTO to entity
		User user = modelMapper.map(userDto, User.class);

    user.setPassword((new BCryptPasswordEncoder()).encode(user.getPassword()));

    return userRepository.save(user);
    
    // return new ResponseEntity<>(userRepository.save(u), HttpStatus.CREATED);
  }




  // @PostMapping("/")
  // @ResponseStatus(HttpStatus.CREATED)
  // @ResponseBody
  // public User create(@RequestBody @Valid User u) {
  //   u.setPassword((new BCryptPasswordEncoder()).encode(u.getPassword()));

  //   // return new ResponseEntity<>(userRepository.save(u), HttpStatus.CREATED);
  //   return userRepository.save(u);
  // }

  @GetMapping("/{id}")
  public User findById(@PathVariable("id") UUID id) {
    return userRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Entity not fount."
          )
      );
    // Optional<User> u = userRepository.findById(id);

    // if (u.isPresent())
    //     return u.get();

    // new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity not fount.");
    // return null;
  }

  // @GetMapping("/api/findAllMoreThan/{id}")
  // public List<User> findMoreThan(@PathVariable("id") UUID id) {
  //     return userRepository.findByIdGreaterThan(id);
  // }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ResponseBody
  public User edit(@RequestBody User u, @PathVariable("id") UUID id) {
    return userRepository.save(u);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") UUID id) {
    userService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
