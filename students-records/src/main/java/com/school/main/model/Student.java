package com.school.main.model;

public class Student {
	
	private String name;
	
	private int rollNum;
	
	private String standard;
	

	public Student(String name, int rollNum, String standard) {
		super();
		this.name = name;
		this.rollNum = rollNum;
		this.standard = standard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

}
