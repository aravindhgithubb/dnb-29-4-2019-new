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
@Table(name = "visits")
public class Visits implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "emprofid")
	private String emprofid;
	
	@Column(name = "exhibitionid")
	private String exhibitionid;
	
	@Column(name = "starttime")
	private String starttime;
	
	@Id
	@GeneratedValue
	@JsonBackReference
	@ManyToOne 
	@JoinColumn(name="personid")
	private Person person;
	
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmprofid() {
		return emprofid;
	}

	public void setEmprofid(String emprofid) {
		this.emprofid = emprofid;
	}

	public String getExhibitionid() {
		return exhibitionid;
	}

	public void setExhibitionid(String exhibitionid) {
		this.exhibitionid = exhibitionid;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
