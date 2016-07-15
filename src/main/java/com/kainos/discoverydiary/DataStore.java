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

	public void addDiaryEntry(DiaryEntry diaryEntry) { entries.add(diaryEntry); }

	public List<DiaryEntry> getEntries(int projectId) {
		// return only entries for the current project
		List<DiaryEntry> entriesForProject = Lists.newArrayList();

		for (DiaryEntry entry : entries) {
			if (entry.getProjectID() == projectId)
				entriesForProject.add(entry);
		}

		Collections.sort(entriesForProject, new Comparator<DiaryEntry>() {
			@Override
			public int compare(DiaryEntry z1, DiaryEntry z2) {
				if (z1.getSessionDateAndTime().isAfter(z2.getSessionDateAndTime()))
					return 1;
				if (z1.getSessionDateAndTime().isBefore(z2.getSessionDateAndTime()))
					return -1;
				return 0;
			}
		});

		return entriesForProject;
	}
}
