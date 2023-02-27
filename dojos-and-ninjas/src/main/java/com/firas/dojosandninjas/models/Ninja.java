package com.firas.dojosandninjas.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
@Table(name="Ninjas")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public Long dojoId;
	
    @Size(min=3, max=255) 
    @NotNull(message = "Name is required!") 
    private String firstName;
    
    @Size(min=2, max=50)
    @NotEmpty(message = "Name is required!")
    private String lastName;
    
    @Min(0) 
    @Max(1000) 
    @NotNull
    private Integer age; 
    
	public Ninja() {
	}
	
	public Ninja(@Size(min = 3, max = 255) @NotNull(message = "Name is required!") String firstName,
			@Size(min = 2, max = 50) @NotEmpty(message = "Name is required!") String lastName,
			@Min(0) @Max(1000) @NotNull Integer age, Long dojoId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dojoId = dojoId;
	}

	// getters and setters
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
    public Long getDojoId() {
		return dojoId;
	}

	public void setDojoId(Long dojoId) {
		this.dojoId = dojoId;
	}

}