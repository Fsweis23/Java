package com.firas.projecttwo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firas.projecttwo.models.Dog;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long>{
}