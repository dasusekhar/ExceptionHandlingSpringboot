package com.example.aop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
public class Student {
	@Id
	//@Length(min=2,max=6)
	//@Size(min=1,max=6)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotNull(message="please write name")
	@Length(min=5,max=15)
	private String name;
	@NotNull(message="pleasw write address ")
	private String address;
	@NotNull(message="please write standard")
	private String standard;
	@NotNull(message="please write fee status")
	private String feeStatus;
	@OneToOne(targetEntity=StudentParent.class,cascade=CascadeType.ALL)
	@JoinColumn(name="stu_pk",referencedColumnName="id")
	private StudentParent studentParent;
	
	public StudentParent getStudentParent() {
		return studentParent;
	}
	public void setStudentParent(StudentParent studentParent) {
		this.studentParent = studentParent;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getFeeStatus() {
		return feeStatus;
	}
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}

	

	public Student() {
		super();
	}
	
	
	
	

}
