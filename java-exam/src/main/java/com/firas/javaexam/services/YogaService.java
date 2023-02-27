package com.firas.javaexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.firas.javaexam.models.Yoga;
import com.firas.javaexam.repositories.YogaRepository;

@Service
public class YogaService {

    private final YogaRepository yogaRepo;

    public YogaService(YogaRepository yogaRepo) {
        this.yogaRepo = yogaRepo;
    }

    public Yoga getOne (Long id) {
        Optional<Yoga> Yoga = yogaRepo.findById(id);
        return Yoga.isPresent() ? Yoga.get() : null;
    }

    public List<Yoga> getAll() {
        return (List<Yoga>) yogaRepo.findAll();
    }

    public Yoga create(Yoga dojo) {
        return yogaRepo.save(dojo);
    }

    public Yoga update(Yoga dojo) {
        return yogaRepo.save(dojo);
    }

    public void delete(Long id) {
        yogaRepo.deleteById(id);
    }
}