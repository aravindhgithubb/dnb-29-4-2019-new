package com.dnb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "owns")
public class Owns implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "created")
	private String created;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "lastupdated")
	private String lastupdated;
	
	@Column(name = "nextcontact")
	private String nextcontact;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "owned")
	private String owned;
	
	@Column(name = "bookedsurvey")
	private String bookedsurvey;
	
	@Column(name = "statuschanged")
	private String statuschanged;
	
	@Column(name = "tf3id")
	private String tf3id;
	
	@Column(name = "remindersmsid")
	private String remindersmsid;
	
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

	public String getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}

	public String getNextcontact() {
		return nextcontact;
	}

	public void setNextcontact(String nextcontact) {
		this.nextcontact = nextcontact;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOwned() {
		return owned;
	}

	public void setOwned(String owned) {
		this.owned = owned;
	}

	public String getBookedsurvey() {
		return bookedsurvey;
	}

	public void setBookedsurvey(String bookedsurvey) {
		this.bookedsurvey = bookedsurvey;
	}

	public String getStatuschanged() {
		return statuschanged;
	}

	public void setStatuschanged(String statuschanged) {
		this.statuschanged = statuschanged;
	}

	public String getTf3id() {
		return tf3id;
	}

	public void setTf3id(String tf3id) {
		this.tf3id = tf3id;
	}

	public String getRemindersmsid() {
		return remindersmsid;
	}

	public void setRemindersmsid(String remindersmsid) {
		this.remindersmsid = remindersmsid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
