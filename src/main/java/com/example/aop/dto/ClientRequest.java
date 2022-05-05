package com.example.aop.dto;

import com.example.aop.entity.Student;

public class ClientRequest {
	
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ClientRequest(Student student) {
		super();
		this.student = student;
	}

	public ClientRequest() {
		super();
	}

	@Override
	public String toString() {
		return "ClientRequest [student=" + student + "]";
	}
	

}
