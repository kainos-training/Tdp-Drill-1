package com.kainos.discoverydiary.resources;

import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.views.ContactListView;
import com.kainos.discoverydiary.views.ProjectDashboardView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by seand on 15/07/2016.
 */
public class ContactResourceTest {


    private ContactResource contactResource;
    private DataStore dataStore;

    @Before
    public void setup(){
        dataStore = new DataStore();
        contactResource = new ContactResource(dataStore);
    }

    @Test
    public void index_whenProvidedWithMatchingProojectId_RetrievesContactsFromStore(){
        // Arrange
        final String projectName = "Test project name";
        final String projectDescription = "Test project desc";

        dataStore.AddProject(new Project(1, projectName, projectDescription));
        dataStore.addContact(1, 1, "Sean Devlin", "Graduate Software Engineer", "Kainos",
                "s.devlin2@kainos.com", "02890947271", "07703848293");
        dataStore.addContact(1, 2, "Adam Kane", "Graduate Software Engineer", "Kainos",
                "a.kane@kainos.com", "02878473829", "07794872838");

        // Act
        ContactListView result = (ContactListView)contactResource.index(1);

        // Assert
        assertEquals(result.getContacts().size(), 2);
        assertEquals(result.getTemplateName(), "/Views/contact/contactList.ftl");
    }
}
