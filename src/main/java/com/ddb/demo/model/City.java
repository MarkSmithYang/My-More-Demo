package com.ddb.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class City implements Serializable{
	private static final long serialVersionUID = 1515225732274439296L;

	@Id
	private String id;
	
//	@Column
	private String cityName;
	
//	@Column
	private Date createTime;
	
//	@Column
	private String country;
	
	@OneToMany(mappedBy="city",targetEntity=Person.class)
//	@OneToMany
//	@JoinColumn(name="city",referencedColumnName="id")
	private Set<Person> persons = new HashSet<>(0);
	
//	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private Set<Person> persons = new HashSet<>(0);
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public Set<Person> getPersons() {
//		return persons;
//	}
//
//	public void setPersons(Set<Person> persons) {
//		this.persons = persons;
//	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
