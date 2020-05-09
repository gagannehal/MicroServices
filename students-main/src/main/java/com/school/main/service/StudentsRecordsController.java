package com.school.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.school.main.model.Students;

@RestController
public class StudentsRecordsController {
	
	@Autowired
    private RestTemplate restTemplate;
	

	@GetMapping("/getAll")
	@ResponseBody
	public Students getStudents() {
		
		Students std = restTemplate.getForObject("http://localhost:9091/students/", Students.class);
        System.out.println("RESPONSE " + std);
		return std;
	}
	
	
	
}
