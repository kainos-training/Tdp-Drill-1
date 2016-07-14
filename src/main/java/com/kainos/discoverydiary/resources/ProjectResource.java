package com.kainos.discoverydiary.resources;

import com.codahale.metrics.annotation.Timed;
import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.views.ProjectDashboardView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by seand on 14/07/2016.
 */
@Path("project")
public class ProjectResource {

    final DataStore dataStore;

    public ProjectResource(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Path("{projectId}")
    public View index(@PathParam("projectId") final int projectId) {
        Project project = dataStore.getProjects().stream().filter(x -> x.getId() == projectId).findFirst().get();
        return new ProjectDashboardView(project);
    }

}
