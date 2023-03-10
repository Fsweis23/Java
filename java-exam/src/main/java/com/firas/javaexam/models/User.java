package com.firas.javaexam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "User name is required")
	@Size(min = 5, max = 15, message = "User name needs to be between 5-15 characters")
	private String userName;
	@NotEmpty(message = "Email is required")
	@Email(message = "Invalid Email!")
	private String email;
	@NotEmpty(message = "Password is required")
	@Size(min = 8, message = "Password must be 8 characters or longer")
	private String password;
	
	@NotEmpty(message = "Confirm Password is required")
	@Transient
	private String confirm;
	
    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
    private List<Yoga> instructors;
	
	@Column(updatable = false)
	private Date createdAt;
	@Column(updatable = false)
	private Date updatedAt;
	
	public User() {
	}

	public List<Yoga> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Yoga> instructors) {
		this.instructors = instructors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist // adds the created at date and time to sql on creation
	protected void onCreate() {
	    this.createdAt = new Date();
	}
	
	@PreUpdate // add the updated at date and time when being updated
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}