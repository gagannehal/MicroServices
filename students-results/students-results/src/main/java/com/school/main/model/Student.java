package com.school.main.model;

public class Student {
	
	private String result;
	
	private int rollNum;
	
	private String standard;
	

	public Student(String result, int rollNum, String standard) {
		super();
		this.result = result;
		this.rollNum = rollNum;
		this.standard = standard;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
