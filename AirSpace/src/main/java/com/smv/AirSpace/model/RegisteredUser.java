package com.smv.AirSpace.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "registereduser")
public class RegisteredUser extends User {
	
	protected String name;
	protected String surname;
    @OneToOne(fetch = FetchType.EAGER)
	protected Address address;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	protected List<RegisteredUser> friendsList;



	public RegisteredUser(){

	}


	public RegisteredUser(String name, String surname, Address address, List<RegisteredUser> friendsList) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.friendsList = friendsList;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<RegisteredUser> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(List<RegisteredUser> friendsList) {
		this.friendsList = friendsList;
	}
}
