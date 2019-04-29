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
@Table(name = "personrelations")
public class Personrelations implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "relatedpersonid")
	private String relatedpersonid;
	
	@Column(name = "agentid")
	private String agentid;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "created")
	private String created;
	
	@JsonBackReference
	@ManyToOne 
	@JoinColumn(name="personid")
	private Person person;

	public String getRelatedpersonid() {
		return relatedpersonid;
	}

	public void setRelatedpersonid(String relatedpersonid) {
		this.relatedpersonid = relatedpersonid;
	}

	public String getAgentid() {
		return agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
