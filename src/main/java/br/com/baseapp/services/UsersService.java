package br.com.baseapp.services;

import br.com.baseapp.models.User;
import br.com.baseapp.repositories.UsersRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  @Autowired
  private UsersRepository userRepository;

  public List<User> listAll() {
    return userRepository.findAll();
  }

  public void deleteById(UUID id) {
    userRepository.deleteById(id);
  }
}