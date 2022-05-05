package com.example.aop.service;

import java.util.List;

import com.example.aop.dto.ClientRequest;
import com.example.aop.entity.Student;
import com.example.aop.entity.StudentParent;

public interface StudentService {

	

	Student saveStudents(Student student);

	List<Student> getAllStudents();

	Student getById(int id);

	void deleteById(int id);

	Student updateByIdsStudnet(int id, Student student);

	//Student saveclientsWay(Student student);

	//Student saveclientsWay(StudentParent studentParent);

	//ClientRequest saveclientsWay(Student request);

	ClientRequest saveclientsWay(ClientRequest request);

}
