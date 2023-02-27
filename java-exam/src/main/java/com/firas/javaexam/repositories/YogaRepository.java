package com.firas.javaexam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firas.javaexam.models.Yoga;

@Repository
public interface YogaRepository extends CrudRepository<Yoga, Long>{
}