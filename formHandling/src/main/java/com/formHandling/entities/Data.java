package com.formHandling.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="datas")
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min=2, max=30, message="The length must be 2-30")
	private String name;
	
	@Pattern(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+", message="Enter email in the format someone@xyz.com")
	private String email;
	
	@Pattern(regexp = "^([+]\\d{2})?\\d{10}$", message="Enter 10 digit mobile number")
	private String mobilenumber;
	
	private String state;

	private String gender;
	
	private String profileImage;
	
	@ElementCollection(targetClass=String.class)
	private List<String> skills;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
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
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	public Data(@Size(min = 2, max = 30, message = "The length must be 2-30") String name,
			@Pattern(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+", message = "Enter email in the format someone@xyz.com") String email,
			@Pattern(regexp = "^([+]\\d{2})?\\d{10}$", message = "Enter 10 digit mobile number") String mobilenumber,
			String state, String gender, List<String> skills, String profileImage) {
		super();
		this.name = name;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.state = state;
		this.gender = gender;
		this.skills = skills;
		this.profileImage = profileImage;
	}
	
	public Data() {
		super();
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", email=" + email + ", mobilenumber=" + mobilenumber + ", state="
				+ state + ", gender=" + gender + ", skills=" + skills + ", image=" + profileImage + "]";
	}
	
}
