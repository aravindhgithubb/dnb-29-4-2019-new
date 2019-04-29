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
@Table(name = "interests")
public class Interests implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Column(name = "exchangeid")
	private String exchangeid;
	
	@Column(name = "created")
	private String created;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "lastupdated")
	private String lastupdated;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "statuschanged")
	private String statuschanged;
	
	@Column(name = "interestedinmatches")
	private String interestedinmatches;
	
	@Column(name = "nextfollowup")
	private String nextfollowup;
	
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatuschanged() {
		return statuschanged;
	}

	public void setStatuschanged(String statuschanged) {
		this.statuschanged = statuschanged;
	}

	public String getInterestedinmatches() {
		return interestedinmatches;
	}

	public void setInterestedinmatches(String interestedinmatches) {
		this.interestedinmatches = interestedinmatches;
	}

	public String getNextfollowup() {
		return nextfollowup;
	}

	public void setNextfollowup(String nextfollowup) {
		this.nextfollowup = nextfollowup;
	}

	public String getExchangeid() {
		return exchangeid;
	}

	public void setExchangeid(String exchangeid) {
		this.exchangeid = exchangeid;
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
