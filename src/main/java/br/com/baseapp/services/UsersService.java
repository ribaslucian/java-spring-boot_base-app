package br.com.baseapp.services;

import br.com.baseapp.dtos.users.UserCreateDto;
import br.com.baseapp.models.User;
import br.com.baseapp.repositories.UsersRepository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  @Autowired
  private UsersRepository userRepository;

  public List<User> listAll() {
    return userRepository.findAll();
  }

  @Transactional
  public User create(User user) {
    user.setPassword((new BCryptPasswordEncoder()).encode(user.getPassword()));
    return userRepository.save(user);
    // return new ResponseEntity<>(userRepository.save(u), HttpStatus.CREATED);
  }

  public void deleteById(UUID id) {
    userRepository.deleteById(id);
  }

  // public void updateById(UUID id) {
  //   // userRepository.deleteById(id);
  // }
}
