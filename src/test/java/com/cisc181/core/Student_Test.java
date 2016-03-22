package com.cisc181.core;
import com.cisc181.eNums.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	private static ArrayList<Course> courses = new ArrayList();
	private static ArrayList<Semester> semesters = new ArrayList();
	private static ArrayList<Section> sections = new ArrayList();
	private static ArrayList<Student> students = new ArrayList();
	@BeforeClass
	public static void addData() throws PersonException {
		//COURSES
		//Course 1
		Course course = new Course();
		course.setCourseID(UUID.randomUUID());
		course.setCourseName("Physics");
		course.setGradePoints(4);
		course.seteMajor(eMajor.PHYSICS);
		courses.add(course);
		
		//Course 2
		course = new Course();
		course.setCourseID(UUID.randomUUID());
		course.setCourseName("Chemistry");
		course.setGradePoints(3);
		course.seteMajor(eMajor.CHEM);
		courses.add(course);
		
		//Course 3
		course = new Course();
		course.setCourseID(UUID.randomUUID());
		course.setCourseName("Nursing");
		course.setGradePoints(3);
		course.seteMajor(eMajor.NURSING);
		courses.add(course);
		
		//SEMESTERS
		//Semester 1
		Semester semester = new Semester();
		semester.setSemesterID(UUID.randomUUID());
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, Calendar.AUGUST,25);
		semester.setStartDate(calendar.getTime());
		calendar.set(2015, Calendar.DECEMBER, 24);
		semester.setEndDate(calendar.getTime());
		semesters.add(semester);
		
		//Semester 2
		semester = new Semester();
		semester.setSemesterID(UUID.randomUUID());
		calendar.set(2014, Calendar.JANUARY,25);
		semester.setStartDate(calendar.getTime());
		calendar.set(2015, Calendar.MAY, 24);
		semester.setEndDate(calendar.getTime());
		semesters.add(semester);
		
		//ADD SECTIONS TO COURSE AND SEMESTER
		
		for (Semester a:semesters){
			for (Course b:courses){
				Section section = new Section();
				section.setCourseID(b.getCourseID());
				section.setSemesterID(a.getSemesterID());
				section.setRoomID(111);
				sections.add(section);
				
				section = new Section();
				section.setCourseID(b.getCourseID());
				section.setSemesterID(a.getSemesterID());
				section.setRoomID(100);
				sections.add(section);
			}
		}
		
		//STUDENTS
		//Student 1
		calendar.set(1997,  Calendar.OCTOBER, 7);
		Student student = new Student("Melanie", "C", "Wolff", calendar.getTime(), eMajor.COMPSI, "3 Countryside Road", "(908)-222-3432", "mwolff@udel.edu");
		students.add(student);
		//Student 2
		calendar.set(1998,  Calendar.JULY, 24);
		student = new Student("Brandon", "M", "Wolff", calendar.getTime(), eMajor.COMPSI, "3 Countryside Road", "(908)-342-9990", "bwolff@udel.edu");
		students.add(student);
		//Student 3
		calendar.set(1964,  Calendar.MARCH, 19);
		student = new Student("Neal", "M", "Wolff", calendar.getTime(), eMajor.COMPSI, "3 Countryside Road", "(908)-222-1839", "nwolff@udel.edu");
		students.add(student);
		//Student 4
		calendar.set(1997,  Calendar.JUNE,18);
		student = new Student("Kimberly", "R", "Wolff", calendar.getTime(), eMajor.COMPSI, "3 Countryside Road", "(908)-222-2353", "kwolff@udel.edu");
		students.add(student);
		//Student 5
		calendar.set(1997,  Calendar.MARCH, 20);
		student = new Student("Marlene", "E", "Wolff", calendar.getTime(), eMajor.BUSINESS, "3 Countryside Road", "(908)-112-0093", "mwolff1@udel.edu");
		students.add(student);
		//Student 6
		calendar.set(1997,  Calendar.AUGUST, 16);
		student = new Student("Zach", "J", "Fischer", calendar.getTime(), eMajor.BUSINESS, "40 Oriole Drive", "(908)-119-2342", "zachf@udel.edu");
		students.add(student);
		//Student 7
		calendar.set(1997,  Calendar.OCTOBER, 24);
		student = new Student("Stephanie", "C", "Ranque", calendar.getTime(), eMajor.COMPSI, "3 Dewing Court", "(908)-333-3432", "stephr@udel.edu");
		students.add(student);
		//Student 8
		calendar.set(1997,  Calendar.JANUARY, 22);
		student = new Student("Andrew", "R", "Anderson", calendar.getTime(), eMajor.NURSING, "44 Anderson Road", "(908)-222-1123", "anderson@udel.edu");
		students.add(student);
		//Student 9
		calendar.set(1997,  Calendar.FEBRUARY, 17);
		student = new Student("Jenn", "A", "Banks", calendar.getTime(), eMajor.CHEM, "3 Dingo Lane", "(908)-213-0032", "Jenn@udel.edu");
		students.add(student);
		//Student 10
		calendar.set(1997,  Calendar.APRIL, 30);
		student = new Student("Alex", "F", "Jenkinson", calendar.getTime(), eMajor.CHEM, "143 Blackbird Road", "(908)-202-3432", "Alex@udel.edu");
		students.add(student);
	}
	//Get Course Hours
	private int getCourseHours(UUID sectionID){
		for (Section section: sections){
			if (section.getSectionID()==(sectionID)){
				for (Course course: courses){
					if (course.getCourseID()== (section.getCourseID())){
						return course.getGradePoints();
					}
				}
			}throw new RuntimeException("This course does not exist");
		}
	
	throw new RuntimeException ("This section does not exist");
}
	//GPA
	//Take total grade and divide by total hours
	private double getGPA1(ArrayList<Enrollment> enrollments, Student student){
		ArrayList<Enrollment> output = new ArrayList();
		for (Enrollment enrollment: enrollments){
			if (enrollment.getStudentsID() == (student.getStudentID())){
				output.add(enrollment);
			}
		}
		double grade_sum = 0;
		int total_sum = 0;
		for (Enrollment enrollment:output){
			UUID id = enrollment.getSectionID();
			double grade_points = enrollment.getGrade();
			double class_hours = getCourseHours(id);
			grade_sum += grade_points;
			total_sum += class_hours;
			}
		double GPA = grade_sum / total_sum;
		return GPA;
	}

	
//Get GPA based on grade scale
	private double getGPA(double grade){
		if (grade<0){
			throw new RuntimeException("Grade should be a value between 0 and 100");
		}
		if (grade < 60){
			return 0;
		}
		if (grade<70){
			return 1;
		}
		if (grade<80){
			return 2;
		}
		if (grade<90){
			return 3;
		}
		if (grade <=100){
			return 4;
		}
		else{
			throw new RuntimeException("Grade should be a value between 0 and 100");
		}
	}

	
	@Test
	//Test to enroll students
	public void testEnrollment() {
		ArrayList<Enrollment> enrollments = new ArrayList();
		for (Section sections:sections){
			//Student 1
			Student student = students.get(0);
			Enrollment enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(100);
			enrollments.add(enrollment);
			//Student 2
			student = students.get(1);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(89);
			enrollments.add(enrollment);
			//Student 3
			student = students.get(2);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(95);
			enrollments.add(enrollment);
			//Student 4
			student = students.get(3);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(88);
			enrollments.add(enrollment);
			//Student 5
			student = students.get(4);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(100);
			enrollments.add(enrollment);
			//Student 6
			student = students.get(5);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(93);
			enrollments.add(enrollment);
			//Student 7
			student = students.get(6);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(92);
			enrollments.add(enrollment);
			//Student 8
			student = students.get(7);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(97);
			enrollments.add(enrollment);
			//Student 9
			student = students.get(8);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(100);
			enrollments.add(enrollment);
			//Student 10
			student = students.get(9);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(90);
			enrollments.add(enrollment);
			}
		assertEquals(getGPA(100),4,0);
		assertEquals(getGPA(89), 4,0);
		assertEquals(getGPA(95), 3, 0);
		assertEquals(getGPA(88), 4,0);
		assertEquals(getGPA(100), 4,0);
		assertEquals(getGPA(93), 4,0);
		assertEquals(getGPA(92), 4,0);
		assertEquals(getGPA(97), 4, 0);
		assertEquals(getGPA(100), 4,0);
		assertEquals(getGPA(90), 4,0);
	
	
	//Change major
	students.get(2).seteMajor(eMajor.CHEM);
	
	}
	
	@Test
	//Test Course Average Grade
	public double getAverage(ArrayList<Enrollment> enrollments, Course course){
		
		ArrayList<Enrollment> total_amount_grades = enrollments;
		
		ArrayList<Course> Physics_average = new ArrayList();
		ArrayList<Course> Nursing_average = new ArrayList();
		ArrayList<Course> Chemistry_average = new ArrayList();
		ArrayList<Course> Comp_sci_average = new ArrayList();
		ArrayList<Course> Business_average = new ArrayList();
		if (course.getCourseName()=="Physics"){
			for (Enrollment enrollment : total_amount_grades){
				double total = 0;
				total = total + enrollment.getGrade();
				Physics_average.add(total);
				
				double PhysicsAverage = total/Physics_average.size();
				return PhysicsAverage;
			}
			}
		if (course.getCourseName() == "Nursing"){
			for (Enrollment enrollment : total_amount_grades){
				double total = 0;
				total = total + enrollment.getGrade();
				Nursing_average.add(total);
				
				double NursingAverage = total/Nursing_average.size();
				return NursingAverage;
			
		}
		}
		if (course.getCourseName()=="Chemistry"){
			for (Enrollment enrollment : total_amount_grades){
				double total = 0;
				total = total + enrollment.getGrade();
				Chemistry_average.add(total);
				
				double ChemAverage = total/Chemistry_average.size();
				return ChemAverage;
		}
			
		}
		if (course.getCourseName()== "Computer Science"){
			for (Enrollment enrollment : total_amount_grades){
				double total = 0;
				total = total + enrollment.getGrade();
				Comp_sci_average.add(total);
				
				double CompSciAverage = total/Comp_sci_average.size();
				return CompSciAverage;
			
		}
		}
		if (course.getCourseName()=="Business"){
			for (Enrollment enrollment : total_amount_grades){
				double total = 0;
				total = total + enrollment.getGrade();
				Business_average.add(total);
				
				double BusinessAverage = total/Business_average.size();
				return BusinessAverage;
		}
			
		}
		else{
			throw new RuntimeException ("This course does not exist");
		}
		assertEquals(getAverage(enrollments, course),(50+60+100+100+98+89+90)/7,0);
		}

@Test
public void testAverage(){
	for (Course course:courses){
		assertEquals(84,(50+60+100+100+98+89+90)/7,0);
	}
}
}