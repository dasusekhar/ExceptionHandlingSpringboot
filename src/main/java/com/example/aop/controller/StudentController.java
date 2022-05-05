package com.example.aop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.dto.ClientRequest;
import com.example.aop.entity.Student;
import com.example.aop.exception.BusinessException;
import com.example.aop.service.StudentService;
@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
private StudentService studentService;
	
	
	@PostMapping("/saveStudents")
	public ResponseEntity<Student>saveStudents(@Valid @RequestBody Student student)
	{
		Student saveStudents=studentService.saveStudents(student);
		return new ResponseEntity<>(saveStudents,HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>>getAllStudents() 
	{
		List<Student> getAll=studentService.getAllStudents();
		return new ResponseEntity<>(getAll,HttpStatus.OK);
	}
	@GetMapping("getById/{id}")
	public ResponseEntity<Student>getByIdStudents(@PathVariable int id)
	{
		Student getByIds=studentService.getById(id);
		return new ResponseEntity<>(getByIds,HttpStatus.OK);
	}
	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<Student>deleteByIdStudents(@PathVariable int id)
	{
		studentService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<Student>updateStudents( @PathVariable int id,@Valid  @RequestBody Student student)
	{
		Student updateStudents=studentService.updateByIdsStudnet(id,student);
		return new ResponseEntity<>(updateStudents,HttpStatus.OK);
	}
	
	@PostMapping("/saveData")
	public ResponseEntity<?>saveClient(@RequestBody ClientRequest request)
	{
		ClientRequest req=studentService.saveclientsWay(request);
		return new ResponseEntity<>(req,HttpStatus.ACCEPTED);
	}
}
