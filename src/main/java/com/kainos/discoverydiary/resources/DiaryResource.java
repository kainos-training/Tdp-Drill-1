package com.kainos.discoverydiary.resources;

import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.views.DiaryAddView;
import com.kainos.discoverydiary.views.DiaryEntryListView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Resource file for routing Diary Entry requests
 */
@Path("project")
public class DiaryResource {
    final DataStore dataStore;
    final DiscoveryDiaryConfiguration configuration;

    public DiaryResource(DataStore dataStore, DiscoveryDiaryConfiguration configuration) {
        this.dataStore = dataStore;
        this.configuration = configuration;
    }

    @Path("{projectId}/diary")
    @GET
    public View listDiaryEntries(@PathParam("projectId") int projectId) {
        Project project = dataStore.getProject(projectId);
        return new DiaryEntryListView(dataStore.getEntries(), project);
    }

    @Path("{projectId}/diary/add")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public View addDiary(@PathParam("projectId") int projectId){
        Project project = dataStore.getProject(projectId);
        return new DiaryAddView(new ArrayList<String>(), project);
    }

}
