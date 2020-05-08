package com.school.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.school.main.model.Student;
import com.school.main.model.Students;

@Repository
public class StudentsDAO {
	
	
	public Students getAllStudents() {
		
		List<Student> studentList = new ArrayList<>();
		
		Student s1 = new Student("Pass", 11 , "Tenth");
		Student s2 = new Student("Fail", 12 , "Seventh");
		Student s3 = new Student("Pass", 11 , "Ninth");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		return new Students(studentList);
	}

}
