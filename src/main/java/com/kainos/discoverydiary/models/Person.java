package com.kainos.discoverydiary.models;

import java.util.UUID;

public class Person {

	int id;

	int projectId;

	String name;

	String jobTitle;

	String company;

	String email;

	String number;

	String mobile;

	Integer age;

	String profilePictureName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProjectId() { return projectId; }

	public void setProjectId(int projectId) {this.projectId = projectId; }

	public String getJobTitle() { return jobTitle; }

	public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

	public String getNumber() { return number; }

	public void setNumber(String number) { this.number = number; }

	public String getCompany() { return company; }

	public void setCompany(String company) { this.company = company; }

	public String getEmail(){ return email; }

	public void setEmail(String email) { this.email = email; }

	public String getMobile() { return mobile; }

	public void setMobile(String mobile) { this.mobile = mobile; }

	public String getProfilePictureName() {
		return profilePictureName;
	}

	public void setProfilePictureName(String profilePictureName) {
		this.profilePictureName = profilePictureName;
	}
}
