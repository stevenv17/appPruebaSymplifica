package com.steven.prueba.symplifica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotBlank(message = "Name is mandatory")
	@Size(max=64, message = "Name field max size is 64")
	@Column(name="name")
	private String name;
	
	
	@NotBlank(message = "Last name is mandatory")
	@Size(max=128, message = "Last name field max size is 128")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "Email is mandatory")
	@Size(max=64, message = "Email field max size is 64")
	@Email(message = "Please enter a valid email address")
	@Column(name="email")
	private String email;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
