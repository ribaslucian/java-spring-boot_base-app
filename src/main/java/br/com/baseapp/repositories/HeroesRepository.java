package br.com.baseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.baseapp.models.Hero;

public interface HeroesRepository extends JpaRepository<Hero, Long> {
// public interface HeroesRepository extends CrudRepository<Hero, Long> {
    
}
