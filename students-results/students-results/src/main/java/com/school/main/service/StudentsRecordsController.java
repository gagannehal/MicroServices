package com.school.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.main.dao.StudentsDAO;
import com.school.main.model.Students;

@RestController
public class StudentsRecordsController {
	
	@Autowired
	StudentsDAO studentsdao;

	@GetMapping("/allResults")
	@ResponseBody
	public Students getAllResults() {
		return studentsdao.getAllStudents();
	}
	
	
	
}
