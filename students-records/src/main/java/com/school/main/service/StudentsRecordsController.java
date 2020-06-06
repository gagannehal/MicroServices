package com.school.main.service;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.main.dao.StudentsDAO;
import com.school.main.model.Students;

import io.netty.handler.codec.http.HttpRequest;

@RestController
public class StudentsRecordsController {
	
	@Autowired
	StudentsDAO studentsdao;

	@GetMapping("/students")
	@ResponseBody
	public Students getStudents(HttpRequest request, HttpResponse response) {
		System.out.println(request.headers());
		return studentsdao.getAllStudents();
	}
	
	
	
}
