package com.kainos.discoverydiary.views;

import com.kainos.discoverydiary.models.Person;
import io.dropwizard.views.View;

import java.util.List;

public class ContactListView extends View {

    private final List<Person> contacts;

    public ContactListView(List<Person> contacts) {
        super("/Views/contact/contactList.ftl");
        this.contacts = contacts;
    }

    public List<Person> getContacts() {
        return contacts;
    }
}