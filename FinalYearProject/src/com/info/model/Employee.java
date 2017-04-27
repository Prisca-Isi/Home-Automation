package com.info.model;

public class Employee
{

       private String name;
	   private String email;
	   private String password ;
	   private String age;
	   private String biographie;
	   private String jobroles;
	   private String interest;
	   

	   public Employee() {
		super();
	}
	   
	   public Employee(String name, String email, String password, String age, String biographie, String jobroles,
				String interest) {
			super();
			this.name = name;
			this.email = email;
			this.password = password;
			this.age = age;
			this.biographie = biographie;
			this.jobroles = jobroles;
			this.interest = interest;
		}

	   public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getBiographie() {
		return biographie;
	}


	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}


	public String getJobroles() {
		return jobroles;
	}


	public void setJobroles(String jobroles) {
		this.jobroles = jobroles;
	}


	public String getInterest() {
		return interest;
	}


	public void setInterest(String interest) {
		this.interest = interest;
	}


   

	

}
