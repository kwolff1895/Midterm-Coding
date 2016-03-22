package com.cisc181.core;


import com.cisc181.core.Person;



public class PersonException extends Exception{
	private Person d;

	public PersonException(Person d) {
		super();
		this.d = d;
	}

	public Person getD() {
		return d;
	}
	
}