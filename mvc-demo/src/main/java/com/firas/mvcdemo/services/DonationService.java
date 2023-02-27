package com.firas.mvcdemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.firas.mvcdemo.models.Donation;
import com.firas.mvcdemo.repositories.DonationRepository;

@Service
public class DonationService {

	public final DonationRepository donationRepo;
	
	public DonationService(DonationRepository donationRepo) {
		this.donationRepo = donationRepo;
	}
	
	public List<Donation> donationSearch(String search) {
		return donationRepo.findByDescriptionContaining(search);
	}
	public List<Donation> findAll(){
		return donationRepo.findAll();
	}
	
	public Donation create(Donation donation) {
		return donationRepo.save(donation);
	}
	
	public Donation update(Donation donation) {
		return donationRepo.save(null);
	}
	
	public void Delete(Long id) {
		donationRepo.deleteById(id);
	}
	
	public Donation getOne(Long id) {
		return donationRepo.findById(id).isPresent() ? donationRepo.findById(id).get() : null;
		
//		Optional<Donation> optionalDonation = donationRepo.findById(id);
//		if(optionalDonation.isPresent()) {
//			Donation foundDonation = optionalDonation.get();
//			return foundDonation;
//		} else {
//			return null;
//		}
	}

}
