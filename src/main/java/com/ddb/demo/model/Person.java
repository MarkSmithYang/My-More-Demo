package com.ddb.demo.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity 
@Table
public class Person implements Serializable{
	private static final long serialVersionUID = -5167237188541607842L;
	
	@Id
	private String id;
	
//	@Column
	private String country;
	
//	@Column
	private String address;
	
	@ManyToOne(targetEntity=City.class)
	private City city;
	
	
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "persons")
//	private City city;

	
	
	public String getId() {
		return id;
	}

	public Person(String id, String country, String address) {
	super();
	this.id = id;
	this.country = country;
	this.address = address;
}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

//	public City getCity() {
//		return city;
//	}
//
//	public void setCity(City city) {
//		this.city = city;
//	}
 
}
