package com.cisc181.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cisc181.core.PersonException;

/*
 * comment
 */
public abstract class Person implements java.io.Serializable {

	private Date DOB;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String address;
	private String phone_number;
	private String email_address;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String MiddleName) {
		this.MiddleName = MiddleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date DOB){
		this.DOB = DOB;
		
		
	}

	public void setAddress(String newAddress) {
		address = newAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setPhone(String newPhone_number) {
		phone_number = newPhone_number;
	
	}

	public String getPhone() {
		return phone_number;
	}

	public void setEmail(String newEmail) {
		email_address = newEmail;
	}

	public String getEmail() {
		return email_address;
	}

	/*
	 * Constructors No Arg Constructor
	 */
	public Person() {

	}

	/*
	 * Constructors Constructor with arguments
	 */

	public Person(String FirstName, String MiddleName, String LastName,
			Date DOB, String Address, String Phone_number, String Email)
	{
		this.FirstName = FirstName;
		this.MiddleName = MiddleName;
		this.LastName = LastName;
		this.setDOB(DOB);
		this.address = Address;
		this.setPhone(Phone_number);
		this.email_address = Email;
		
	}

	public void PrintName() {
		System.out.println(this.FirstName + ' ' + this.MiddleName + ' '
				+ this.LastName);
	}

	public void PrintDOB() {
		System.out.println(this.DOB);
	}

	public int PrintAge() throws PersonException {
		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();

		int age = 0;
		birthDate.setTime(this.DOB);
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}
		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

		// If birth date is over 100 years old
		if (today.get(Calendar.DAY_OF_YEAR)- birthDate.get(Calendar.DAY_OF_YEAR)>= 100){
			throw new PersonException(null);
		}
		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
		
		// If birth date is greater than todays date (after 2 days adjustment of
		// leap year) then decrement age one year
		if ((birthDate.get(Calendar.DAY_OF_YEAR)
				- today.get(Calendar.DAY_OF_YEAR) > 3)
				|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
			age--;

			// If birth date and todays date are of same month and birth day of
			// month is greater than todays day of month then decrement age
		} else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
				&& (birthDate.get(Calendar.DAY_OF_MONTH) > today
						.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}

		System.out.println("age is " + age);

		return age;

	}
	
	
	//If phone number is not formatted correctly
	public void PrintPhoneNumber() {
		System.out.println(this.phone_number);
	}

	public void PrintPhone_Number() throws PersonException{
		 List<String> phoneNumbers = new ArrayList<String>();
		 phoneNumbers.add(phone_number);
		 boolean bphoneNumber= false;
		 
		 String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		 
		 Pattern pattern = Pattern.compile(regex);
		  
		 for(String email : phoneNumbers)
		 {
		     Matcher matcher = pattern.matcher(email);
		     System.out.println(email +" : "+ matcher.matches());
		 }
		 
		 if (bphoneNumber == false){
			 throw new PersonException(null);}
			
	
			String regex1 = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
			 
			Pattern pattern1 = Pattern.compile(regex1);{
			 
			for(String PhoneNumber : phoneNumbers)
			{
			    Matcher matcher = pattern1.matcher(PhoneNumber);
			    //System.out.println(Phone_number +" : "+ matcher.matches());
			    //If phone number is correct then format it to (123)-456-7890
			    if(matcher.matches())
			    {
			       System.out.println(matcher.replaceFirst("($1) $2-$3"));
			    }
			    }
		}
	}
}
