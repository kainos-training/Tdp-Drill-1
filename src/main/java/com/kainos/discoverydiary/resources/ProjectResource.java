package com.kainos.discoverydiary.resources;

import com.codahale.metrics.annotation.Timed;
import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.views.PeopleListView;
import com.kainos.discoverydiary.views.ProjectDashboardView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by seand on 14/07/2016.
 */
@Path("project")
public class ProjectResource {

    final DataStore dataStore;
    final DiscoveryDiaryConfiguration configuration;

    public ProjectResource(DataStore dataStore, DiscoveryDiaryConfiguration configuration) {
        this.dataStore = dataStore;
        this.configuration = configuration;
    }

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Path("")
    public View index() {
        Project project = new Project(1, "Government", "This is a sample project and we do no care about the content of " +
                "this sentence.");
        return new ProjectDashboardView(project);
    }

}
