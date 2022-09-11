package br.com.baseapp.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.baseapp.models.User;

public interface UsersRepository extends JpaRepository<User, UUID> {

    // @Query("SELECT u FROM User u WHERE u.id > :id")
    // public List<User> findAllMoreThan(@Param("id") Long id);

    // public List<User> findByIdGreaterThan(UUID id);
    
}
