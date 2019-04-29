package com.dnb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Accomodation")
public class Accomodation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
    @Column(name = "agentid")
	private String agentid;

	@Column(name = "officeid")
	private String officeid;
	
	
	@Column(name = "emprofid")
	private String emprofid;
	
	@Column(name = "parentaccomodationid")
	private String parentaccomodationid;
	
	@Column(name = "postalcode")
	private String postalcode;
	
	@Column(name = "streetaddress")
	private String streetaddress;
	
	@Column(name = "areal")
	private String areal;
	
	@Column(name = "rooms")
	private String rooms;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "created")
	private String created;
	
	@Column(name = "accomodationtype")
	private String accomodationtype;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "charge")
	private String charge;
	
	@Column(name = "sitesize")
	private String sitesize;
	
	@Column(name = "constructionyear")
	private String constructionyear;
	
	@Column(name = "lastupdated")
	private String lastupdated;
	
	@Column(name = "neighbourhood")
	private String neighbourhood;
	
	@Column(name = "town")
	private String town;
	
	@Column(name = "apartmentnumber")
	private String apartmentnumber;
	
	@JsonManagedReference
	@OneToMany(mappedBy="accomodation", targetEntity = Interests.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Interests> interests;
	
	/*@JsonManagedReference
	@OneToMany(mappedBy="accomodation", targetEntity = Biddings.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Biddings> biddings;*/
	
	@JsonManagedReference
	@OneToMany(mappedBy="accomodation", targetEntity = Coowners.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Coowners> coOwners;
	
	@JsonManagedReference
	@OneToMany(mappedBy="accomodation", targetEntity = Owns.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<Owns> owns;
	

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getStreetaddress() {
		return streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public String getAreal() {
		return areal;
	}

	public void setAreal(String areal) {
		this.areal = areal;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getAccomodationtype() {
		return accomodationtype;
	}

	public void setAccomodationtype(String accomodationtype) {
		this.accomodationtype = accomodationtype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getSitesize() {
		return sitesize;
	}

	public void setSitesize(String sitesize) {
		this.sitesize = sitesize;
	}

	public String getConstructionyear() {
		return constructionyear;
	}

	public void setConstructionyear(String constructionyear) {
		this.constructionyear = constructionyear;
	}

	public String getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getApartmentnumber() {
		return apartmentnumber;
	}

	public void setApartmentnumber(String apartmentnumber) {
		this.apartmentnumber = apartmentnumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAgentid() {
		return agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}

	public String getOfficeid() {
		return officeid;
	}

	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}

	public String getEmprofid() {
		return emprofid;
	}

	public void setEmprofid(String emprofid) {
		this.emprofid = emprofid;
	}

	public String getParentaccomodationid() {
		return parentaccomodationid;
	}

	public void setParentaccomodationid(String parentaccomodationid) {
		this.parentaccomodationid = parentaccomodationid;
	}

	public List<Interests> getInterests() {
		return interests;
	}

	public void setInterests(List<Interests> interests) {
		this.interests = interests;
	}

	/*public List<Biddings> getBiddings() {
		return biddings;
	}

	public void setBiddings(List<Biddings> biddings) {
		this.biddings = biddings;
	}*/

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

}
