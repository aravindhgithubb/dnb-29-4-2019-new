package com.dnb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "coowners")
public class Coowners implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "coowner")
	private String coowner;
	
	@Id
	@GeneratedValue
	@JsonBackReference
	@ManyToOne 
	@JoinColumn(name="personid")
	private Person person;
	
	@JsonBackReference
	@ManyToOne 
	@JoinColumn(name="accomodationid")
	private Accomodation accomodation;

	public String getCoowner() {
		return coowner;
	}

	public void setCoowner(String coowner) {
		this.coowner = coowner;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Accomodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accomodation accomodation) {
		this.accomodation = accomodation;
	}

	
}
