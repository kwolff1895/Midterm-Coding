package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void testAverage() {
		ArrayList<Staff> staff_members = new ArrayList();
		Staff Staff_member_one = new Staff(eTitle.MRS);
		Staff Staff_member_two = new Staff (eTitle.MR);
		Staff Staff_member_three = new Staff (eTitle.MS);
		Staff Staff_member_four = new Staff (eTitle.MRS);
		Staff Staff_member_five = new Staff (eTitle.MR);
		Staff_member_one.setSalary(100000);
		Staff_member_two.setSalary(90000);
		Staff_member_three.setSalary(75000);
		Staff_member_four.setSalary(140000);
		Staff_member_five.setSalary(85000);
		staff_members.add(Staff_member_one);
		staff_members.add(Staff_member_two);
		staff_members.add(Staff_member_three);
		staff_members.add(Staff_member_four);
		staff_members.add(Staff_member_five);
		
		double average = 0;
		for (Staff staff: staff_members){
			average += staff.getSalary() / staff_members.size();}
	double result = 100000+90000+75000+140000+85000;
	result= result/5;
	
	assertEquals(average,result, 0);
	}
	//Test Exceptions
	@Test
	public void testExceptions() throws PersonException{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 104);
		Staff staff_member = new Staff(eTitle.MS);
		staff_member.setDOB(calendar.getTime());
		}
	@Test
	public void testExceptions2() throws PersonException{
		Staff staff_member = new Staff(eTitle.MS);
		staff_member.setPhone("(232)3333112");
		}

}
