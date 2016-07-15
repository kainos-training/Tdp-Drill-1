package com.kainos.discoverydiary.resources;

import com.codahale.metrics.annotation.Timed;
import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.models.Person;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.views.ContactListView;
import com.kainos.discoverydiary.views.ProjectDashboardView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by seand on 15/07/2016.
 */
@Path("project/{projectId}/contact")
public class ContactResource {
    final DataStore dataStore;

    public ContactResource(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Path("list")
    public View index(@PathParam("projectId") final int projectId) {
        List<Person> contacts = dataStore.getContacts(projectId);
        Project project = dataStore.getProject(projectId);
        return new ContactListView(contacts, project);
    }
}
