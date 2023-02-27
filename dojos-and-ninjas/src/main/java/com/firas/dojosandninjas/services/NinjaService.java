package com.firas.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.firas.dojosandninjas.models.Ninja;
import com.firas.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	public final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Optional<Ninja> ninjaSearch(Long string) {
		return ninjaRepo.findById(string);
	}
	public List<Ninja> findAllByDojo(Long id){
		return ninjaRepo.findAllByDojoId(id);
	}
	
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja getOne(Long id) {
		return ninjaRepo.findById(id).isPresent() ? ninjaRepo.findById(id).get() : null;
	}

}
