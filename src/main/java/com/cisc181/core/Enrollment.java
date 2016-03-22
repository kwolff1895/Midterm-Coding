package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentsID;
	private UUID EnrollmentID;
	private double Grade;
	
	
	public UUID getSectionID() {
		return SectionID;
	}
	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}
	public UUID getStudentsID() {
		return StudentsID;
	}
	public void setStudentsID(UUID studentsID) {
		StudentsID = studentsID;
	}
	public double getGrade() {
		return Grade;
	}
	public UUID getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(UUID enrollmentID) {
		EnrollmentID = enrollmentID;
	}
	private Enrollment(){
	}
	public Enrollment(UUID SectionID, UUID StudentsID) {
		super();
		this.SectionID = SectionID;
		this.StudentsID = StudentsID;
		this.setEnrollmentID(EnrollmentID);
		}	
	
	
	public void setGrade(double grade) {
		Grade = grade;
	}
	
}
