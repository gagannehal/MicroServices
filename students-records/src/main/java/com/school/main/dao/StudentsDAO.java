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
		
		
		/*
		 * Stream < String > studentStream = Stream.of("Ross, 11 , Tenth",
		 * "Joey, 12 ,Seventh", "Chandler, 11 ,Ninth"); studentList =
		 * studentStream.map(studentStr - > { String[] info = studentStr.split(",");
		 * return new Student(info[0],Integer.valueOf(info[1]), info[2]);
		 * }).collect(Collectors.toList());
		 */
		
		
		Student s1 = new Student("Ross", 11 , "Tenth");
		Student s2 = new Student("Joey", 12 , "Seventh");
		Student s3 = new Student("Chandler", 11 , "Ninth");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		return new Students(studentList);
	}

}
