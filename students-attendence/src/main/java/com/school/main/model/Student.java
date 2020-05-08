package com.school.main.model;

public class Student {
	
	private String attendanceStatus;
	
	private int rollNum;
	
	private String standard;
	

	public Student(String name, int rollNum, String standard) {
		super();
		this.attendanceStatus = name;
		this.rollNum = rollNum;
		this.standard = standard;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
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
