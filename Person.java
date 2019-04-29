package com.dnb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "Person")
@Entity(name = "Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "emprofid")
	private String emprofid;

	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "phone_mobile")
	private String phone_mobile;
	
	@Column(name = "phone_home")
	private String phone_home;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "streetaddress")
	private String streetaddress;
	
	@Column(name = "postalcode")
	private String postalcode;
	
	@Column(name = "economicaladvice")
	private String economicaladvice;
	
	@Column(name = "dreammatch")
	private String dreammatch;
	
	@Column(name = "town")
	private String town;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "hasownership")
	private String hasownership;
	
	@Column(name = "latestadvice")
	private String latestadvice;
	
	@Column(name = "latestbidding")
	private String latestbidding;
	
	@Column(name = "isbuyer")
	private String isbuyer;
	
	@Column(name = "interestedinmatches")
	private String interestedinmatches;
	
	@JsonManagedReference
	@OneToMany(mappedBy="person", targetEntity = Bankcrmlead.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Bankcrmlead> bankCrmLead;
	
	/*@JsonManagedReference
	@OneToMany(mappedBy="person", targetEntity = Biddings.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Biddings> biddings;*/
	
	@JsonManagedReference
	@OneToMany(mappedBy="person", targetEntity = Interests.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Interests> interests;
	
	@JsonManagedReference
	@OneToMany(mappedBy="person", targetEntity = Visits.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Visits> visits;
	
	@JsonManagedReference
	@OneToMany(mappedBy="person", targetEntity = Coowners.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Coowners> coOwners;
	
	@JsonManagedReference
	@OneToMany(mappedBy="person", targetEntity = Owns.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Owns> owns;
	
	@JsonManagedReference
	@OneToMany(mappedBy="person", targetEntity = Personrelations.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Personrelations> personRelations;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone_mobile() {
		return phone_mobile;
	}

	public void setPhone_mobile(String phone_mobile) {
		this.phone_mobile = phone_mobile;
	}

	public String getPhone_home() {
		return phone_home;
	}

	public void setPhone_home(String phone_home) {
		this.phone_home = phone_home;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreetaddress() {
		return streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getEconomicaladvice() {
		return economicaladvice;
	}

	public void setEconomicaladvice(String economicaladvice) {
		this.economicaladvice = economicaladvice;
	}

	public String getDreammatch() {
		return dreammatch;
	}

	public void setDreammatch(String dreammatch) {
		this.dreammatch = dreammatch;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getHasownership() {
		return hasownership;
	}

	public void setHasownership(String hasownership) {
		this.hasownership = hasownership;
	}

	public String getLatestadvice() {
		return latestadvice;
	}

	public void setLatestadvice(String latestadvice) {
		this.latestadvice = latestadvice;
	}

	public String getLatestbidding() {
		return latestbidding;
	}

	public void setLatestbidding(String latestbidding) {
		this.latestbidding = latestbidding;
	}

	public String getIsbuyer() {
		return isbuyer;
	}

	public void setIsbuyer(String isbuyer) {
		this.isbuyer = isbuyer;
	}

	public String getInterestedinmatches() {
		return interestedinmatches;
	}

	public void setInterestedinmatches(String interestedinmatches) {
		this.interestedinmatches = interestedinmatches;
	}

	public void setEmprofid(String emprofid) {
		this.emprofid = emprofid;
	}

	public String getEmprofid() {
		return emprofid;
	}

	public List<Bankcrmlead> getBankCrmLead() {
		return bankCrmLead;
	}

	public void setBankCrmLead(List<Bankcrmlead> bankCrmLead) {
		this.bankCrmLead = bankCrmLead;
	}

	/*public List<Biddings> getBiddings() {
		return biddings;
	}

	public void setBiddings(List<Biddings> biddings) {
		this.biddings = biddings;
	}*/

	public List<Interests> getInterests() {
		return interests;
	}

	public void setInterests(List<Interests> interests) {
		this.interests = interests;
	}

	public List<Visits> getVisits() {
		return visits;
	}

	public void setVisits(List<Visits> visits) {
		this.visits = visits;
	}

	public List<Coowners> getCoOwners() {
		return coOwners;
	}

	public void setCoOwners(List<Coowners> coOwners) {
		this.coOwners = coOwners;
	}

	public List<Owns> getOwns() {
		return owns;
	}

	public void setOwns(List<Owns> owns) {
		this.owns = owns;
	}

	public List<Personrelations> getPersonRelations() {
		return personRelations;
	}

	public void setPersonRelations(List<Personrelations> personRelations) {
		this.personRelations = personRelations;
	}
	
}
