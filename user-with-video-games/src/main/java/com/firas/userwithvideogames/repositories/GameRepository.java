package com.firas.userwithvideogames.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firas.userwithvideogames.models.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long>{
}