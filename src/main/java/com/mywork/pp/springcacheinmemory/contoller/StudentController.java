package com.mywork.pp.springcacheinmemory.contoller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywork.pp.springcacheinmemory.model.Student;
import com.mywork.pp.springcacheinmemory.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students/{id}")
	public Student findStudentById(@PathVariable String id) {
		System.out.println("Searching by ID  : " + id);
		return studentService.getStudentByID(id);
	}
	
	@RequestMapping("/foo")
	  void handleFoo(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    System.out.println("FOO URL is "+ request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/students/1");
	  }
}
