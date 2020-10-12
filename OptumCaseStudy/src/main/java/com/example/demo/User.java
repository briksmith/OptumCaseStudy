package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String FIRSTNAME;
	
	@Column
	private char middleInitial;
	
	@Column
	private String LASTNAME;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String ZIP;
	
	@Column
	private String phoneNumber;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName) {
		this.FIRSTNAME = firstName;
		this.LASTNAME = lastName;
	}
	public User(String firstName, char middleInitial, String lastName, String city, String state, String zip,
			String phoneNumber) {
		super();
		this.FIRSTNAME = firstName;
		this.middleInitial = middleInitial;
		this.LASTNAME = lastName;
		this.city = city;
		this.state = state;
		ZIP = zip;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return FIRSTNAME;
	}
	public void setFirstName(String firstName) {
		this.FIRSTNAME = firstName;
	}
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return LASTNAME;
	}
	public void setLastName(String lastName) {
		this.LASTNAME = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZIP() {
		return ZIP;
	}
	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ZIP == null) ? 0 : ZIP.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((FIRSTNAME == null) ? 0 : FIRSTNAME.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((LASTNAME == null) ? 0 : LASTNAME.hashCode());
		result = prime * result + middleInitial;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (ZIP == null) {
			if (other.ZIP != null)
				return false;
		} else if (!ZIP.equals(other.ZIP))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (FIRSTNAME == null) {
			if (other.FIRSTNAME != null)
				return false;
		} else if (!FIRSTNAME.equals(other.FIRSTNAME))
			return false;
		if (id != other.id)
			return false;
		if (LASTNAME == null) {
			if (other.LASTNAME != null)
				return false;
		} else if (!LASTNAME.equals(other.LASTNAME))
			return false;
		if (middleInitial != other.middleInitial)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + FIRSTNAME + ", middleInitial=" + middleInitial + ", lastName="
				+ LASTNAME + ", city=" + city + ", state=" + state + ", ZIP=" + ZIP + ", phoneNumber=" + phoneNumber
				+ "]";
	}

	public long getId() {
		return id;
	}
	
	
	
}
