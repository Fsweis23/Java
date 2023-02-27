package com.firas.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.firas.dojosandninjas.models.Dojo;
import com.firas.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	public final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public Optional<Dojo> dojoSearch(Long id) {
		return dojoRepo.findById(id);
	}
	public List<Dojo> findAll(){
		return dojoRepo.findAll();
	}
	
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo getOne(Long id) {
		return dojoRepo.findById(id).isPresent() ? dojoRepo.findById(id).get() : null;
	}

}
