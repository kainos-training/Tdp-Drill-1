package com.kainos.discoverydiary;

import com.google.common.collect.Lists;
import com.kainos.discoverydiary.models.DiaryEntry;
import com.kainos.discoverydiary.models.Person;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.models.SessionType;

import java.util.Collections;
import java.util.Comparator;
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

		Project result = null;

		for(Project project : getProjects()){
			if(project.getId() == projectId){
				result = project;
				break;
			}
		}

		return result;
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

	private static List<DiaryEntry> entries = Lists.newArrayList();

	// Dummy date for diary entries
	static {
		entries.add(new DiaryEntry(SessionType.VISION, "Diary Entry 1", "18/06/2016", "16:00:00", "Test 1"));
		entries.add(new DiaryEntry(SessionType.GOALS, "Diary Entry 2",  "21/06/2016", "17:00:00", "Test 2"));
		entries.add(new DiaryEntry(SessionType.NFRs, "Diary Entry 3", "02/06/2016", "18:00:00", "Test 3"));
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
