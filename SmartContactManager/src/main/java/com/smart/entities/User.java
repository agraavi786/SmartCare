package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "User Name can not be empty")
	@Size(min=3,max=20,message = "User name must be between 3-20 character !!")
	private String name;
	@Email(regexp =  "^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-Z]+$")
	private String email;
	@Size(min=8, max=20 , message="paswword contains 8 characters")
	
	private String password;
	
	private String role;
	private Boolean enable;
	private String imageUrl;
	
	@Column(length = 500)
	private String about;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY,mappedBy = "user") // if want to add user then it save all the contacts and if 
	//you delete the contacts then it will delete all the contacts
	public List<Contact> contacts = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public List<Contact> getContacts() {
		return contacts;
	}



	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", enable=" + enable + ", imageUrl=" + imageUrl + ", about=" + about + ", contacts=" + contacts + "]";
	}
	
	
	
	

}
