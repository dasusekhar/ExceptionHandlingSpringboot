package com.example.aop.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aop.dto.ClientRequest;
import com.example.aop.entity.Student;
import com.example.aop.entity.StudentParent;
import com.example.aop.exception.BusinessException;
import com.example.aop.exception.NoSuchElementException;
import com.example.aop.repository.ParentRepository;
import com.example.aop.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ParentRepository parentRepository;

	@Override
	public Student saveStudents(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() throws BusinessException
{
		
		List<Student> stu=null;
		try
		{
			   stu=studentRepository.findAll();
		}catch(Exception e)
		{
			throw new BusinessException("601","not data is present here ...........!");
			
		}
		if(stu.isEmpty())
		{
			throw new BusinessException("602","hey completely empty .......!");
			
		}
		return stu;

		
	}

	@Override
	public Student getById(int id) {
		List<Student> ids=studentRepository.findAll();
		if(!ids.contains(id))
		{
			throw new NoSuchElementException("606","not id is not there in the  record");
		}
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		List<Student> del=studentRepository.findAll();
		if(!del.contains(id))
		{
			throw new NoSuchElementException("609","not records");
		}
	  studentRepository.deleteById(id);
		
	}

	@Override
	public Student updateByIdsStudnet(int id, Student student) {
		Student sts=studentRepository.findById(id).get();
		sts.setName(student.getName());
		sts.setAddress(student.getAddress());
		sts.setFeeStatus(student.getFeeStatus());
		
		
		return  studentRepository.save(sts);
	}

	@Override
	public ClientRequest saveclientsWay(ClientRequest request) {
    
		
		return studentRepository.save(request);
	}

	

	
	

	

	

}
