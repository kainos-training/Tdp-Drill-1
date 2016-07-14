package com.kainos.discoverydiary;

import com.google.common.collect.Lists;
import com.kainos.discoverydiary.models.DiaryEntry;
import com.kainos.discoverydiary.models.Person;
import com.kainos.discoverydiary.models.SessionType;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DataStore {

	private static List<Person> people = Lists.newArrayList();

	public List<Person> getPeople() {
		return people;
	}

	public void registerPerson(UUID id, String name, Integer age, String profilePictureName) {
		Person newPerson = new Person();
		newPerson.setId(id);
		newPerson.setName(name);
		newPerson.setAge(age);
		newPerson.setProfilePictureName(profilePictureName);
		people.add(newPerson);
	}

	private static List<DiaryEntry> entries = Lists.newArrayList();

	// Dummy date for diary entries
	static {
		entries.add(new DiaryEntry(SessionType.VISION, "Diary Entry 1", new Date(2016,07,07), new Time(16,00,00), "Test 1"));
		entries.add(new DiaryEntry(SessionType.GOALS, "Diary Entry 2", new Date(2016,07,07), new Time(17,00,00), "Test 2"));
		entries.add(new DiaryEntry(SessionType.NFRs, "Diary Entry 3", new Date(2016,07,07), new Time(18,00,00), "Test 3"));
	}

	public List<DiaryEntry> getEntries() { return entries; }
}
