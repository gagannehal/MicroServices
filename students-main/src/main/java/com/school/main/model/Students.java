package com.school.main.model;

import java.util.List;

public class Students {

	private List<Student> students;

	public Students() {

	}

	public Students(List<Student> students) {
		super();
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Students [students=" + students + "]";
	}
	

}
