package com.kainos.discoverydiary;

import com.google.common.collect.Lists;
import com.kainos.discoverydiary.models.Person;
import com.kainos.discoverydiary.models.Project;

import java.util.List;
import java.util.UUID;

public class DataStore {

	private static List<Person> people = Lists.newArrayList();

	private static List<Project> projects = Lists.newArrayList();


	public List<Person> getPeople() {
		return people;
	}

	public List<Project> getProjects() { return  projects; }

	public Project getProject(int projectId){
		return projects.stream().filter(x -> x.getId() == projectId).findFirst().get();
	}

	public void registerPerson(UUID id, String name, Integer age, String profilePictureName) {
		Person newPerson = new Person();
		newPerson.setId(id);
		newPerson.setName(name);
		newPerson.setAge(age);
		newPerson.setProfilePictureName(profilePictureName);
		people.add(newPerson);
	}

	public void AddProject(Project project){
		projects.add(project);
	}


}
