package com.kainos.discoverydiary.views;

import com.kainos.discoverydiary.models.Person;
import com.kainos.discoverydiary.models.Project;
import io.dropwizard.views.View;

import java.util.List;

public class ContactListView extends View {

    private final List<Person> contacts;
    private final Project project;

    public ContactListView(List<Person> contacts, Project project) {
        super("/Views/contact/contactList.ftl");
        this.contacts = contacts;
        this.project = project;
    }

    public List<Person> getContacts() {
        return contacts;
    }

    public Project getProject() { return  project; }
}