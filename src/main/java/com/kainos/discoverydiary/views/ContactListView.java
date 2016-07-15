package com.kainos.discoverydiary.views;

import io.dropwizard.views.View;

import java.util.List;

public class ContactListView extends View {

    private final List<String> errors;

    public ContactListView(List<String> errors) {
        super("/Views/contact/contactList.ftl");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}