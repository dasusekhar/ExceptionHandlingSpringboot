package com.example.aop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class  StudentParent {
	@Id
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String parentName;
	private String mobile;
	//@OneToOne(cascade=CascadeType.ALL)
	//private Student student;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public StudentParent(int id, String parentName, String mobile) {
		super();
		this.id = id;
		this.parentName = parentName;
		this.mobile = mobile;
	}
	public StudentParent() {
		super();
	}
	@Override
	public String toString() {
		return "StudentParent [id=" + id + ", parentName=" + parentName + ", mobile=" + mobile + "]";
	}
	

}
