package com.example.aop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aop.dto.ClientRequest;
import com.example.aop.entity.StudentParent;

@Repository
public interface ParentRepository extends JpaRepository<StudentParent,Integer> {

	void save(ClientRequest request);

}
