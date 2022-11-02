package com.auth.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class User {
	
	@Id Long id;
	String name;
	@Index String email;
	String city;
	String gender;
	int age;
	@Index String password;
	
	public User() {
		
	}
	
	public User(String name, String email ,String city, int age, String gender, String password) {
		
		this.name = name;
		this.email = email;
		this.city = city;
		this.gender = gender;
		this.age = age;
		this.password = password;
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

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", gender=" + gender
				+ ", age=" + age + ", password=" + password + "]";
	}

	
	
	
	
	
}
