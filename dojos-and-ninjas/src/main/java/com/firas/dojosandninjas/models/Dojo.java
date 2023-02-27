package com.firas.dojosandninjas.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
@Table(name="Dojos")
public class Dojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Size(min=3, max=255) 
    @NotNull(message = "Name is required!") 
    private String name;
    
	public Dojo() {
	}
	
	public Dojo(@Size(min = 3, max = 255) @NotNull(message = "Name is required!") String name) {
		super();
		this.name = name;
	}

	// getters and setters
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}