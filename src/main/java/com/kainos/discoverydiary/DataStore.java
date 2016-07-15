package com.kainos.discoverydiary;

import com.google.common.collect.Lists;
import com.kainos.discoverydiary.models.DiaryEntry;
import com.kainos.discoverydiary.models.Person;
import com.kainos.discoverydiary.models.Project;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataStore {

	private static List<Person> people = Lists.newArrayList();

	private static List<Project> projects = Lists.newArrayList();

	private static List<Person> contacts = Lists.newArrayList();

	private static int lastUsedDiaryId = 0;


	public List<Person> getPeople() {
		return people;
	}

	public List<Project> getProjects() { return  projects; }

	public Project getProject(int projectId){

		Project result = null;

		for(Project project : getProjects()){
			if(project.getId() == projectId){
				result = project;
				break;
			}
		}

		return result;
	}

	public void registerPerson(int id, String name, Integer age, String profilePictureName) {
		Person newPerson = new Person();
		newPerson.setId(id);
		newPerson.setName(name);
		newPerson.setAge(age);
		newPerson.setProfilePictureName(profilePictureName);
		people.add(newPerson);
	}



	public void addContact(int projectId, int contactId, String name, String jobTitle, String company, String email,
						   String number, String mobile){
		Person newPerson = new Person();
		newPerson.setProjectId(projectId);
		newPerson.setId(contactId);
		newPerson.setName(name);
		newPerson.setJobTitle(jobTitle);
		newPerson.setCompany(company);
		newPerson.setEmail(email);
		newPerson.setNumber(number);
		newPerson.setMobile(mobile);
		contacts.add(newPerson);
	}

	public List<Person> getContacts(int projectId){

		List<Person> result = Lists.newArrayList();

		for(Person contact : contacts){
			if(contact.getProjectId() == projectId){
				result.add(contact);
			}
		}

		return result;
	}


	public void AddProject(Project project){
		projects.add(project);
	}

	private static List<DiaryEntry> entries = Lists.newArrayList();

	public int addDiaryEntry(DiaryEntry diaryEntry)
	{
		lastUsedDiaryId++;
		diaryEntry.setDiaryId(lastUsedDiaryId);
		entries.add(diaryEntry);

		return lastUsedDiaryId;
	}

	public DiaryEntry getEntry(int diaryEntryId){
		DiaryEntry result = null;

		for(DiaryEntry entry : getEntries()){
			if(entry.getDiaryId() == diaryEntryId){
				result = entry;
				break;
			}
		}

		return result;
	}

	public List<DiaryEntry> getEntries() {
		Collections.sort(entries, new Comparator<DiaryEntry>() {
			@Override
			public int compare(DiaryEntry z1, DiaryEntry z2) {
				if (z1.getSessionDateAndTime().isAfter(z2.getSessionDateAndTime()))
					return 1;
				if (z1.getSessionDateAndTime().isBefore(z2.getSessionDateAndTime()))
					return -1;
				return 0;
			}
		});

		return entries;
	}
}
