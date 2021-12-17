package com.mywork.pp.springcacheinmemory.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mywork.pp.springcacheinmemory.model.Student;

@Service
public class StudentService {
	//@CacheEvict(value = {"student"},key = "#id", beforeInvocation = true, condition= "#isNotFromCache")
	//@Cacheable(value="student",key = "#id")
	// public Student getStudentByID(String id, boolean isNotFromCache, condition= "#isNotFromCache") {
	@Cacheable(value="student",key = "#id")
	public Student getStudentByID(String id) {
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Student(id,"Sajal" ,"V");
		
	}
}
