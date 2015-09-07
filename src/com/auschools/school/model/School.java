package com.auschools.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCHOOLS")
public class School {

	private Long id;
	private String name;
	private String area;
	private String year;
	private Boolean privateSchool;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="SCHOOL_ID")	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="SCHOOL_NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="SCHOOL_AREA")
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	@Column(name="SCHOOL_YEAR")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	@Column(name="SCHOOL_PRIVATE")
	public Boolean getPrivateSchool() {
		return privateSchool;
	}
	public void setPrivateSchool(Boolean privateSchool) {
		this.privateSchool = privateSchool;
	}

}
