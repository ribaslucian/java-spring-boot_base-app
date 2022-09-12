package br.com.baseapp.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baseapp.repositories.UsersRepository;
import br.com.baseapp.models.User;

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
