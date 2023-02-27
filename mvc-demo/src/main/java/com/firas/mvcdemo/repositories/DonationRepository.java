package com.firas.mvcdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firas.mvcdemo.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {
    List<Donation> findByDescriptionContaining(String search);
	List<Donation> findAll(); // they need to follow jpa documentation
}
