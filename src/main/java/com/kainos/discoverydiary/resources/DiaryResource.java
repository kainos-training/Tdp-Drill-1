package com.kainos.discoverydiary.resources;

import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
import com.kainos.discoverydiary.models.DiaryEntry;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.views.DiaryEntryListView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

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
        List<DiaryEntry> entries = dataStore.getEntries();
        
        return new DiaryEntryListView(entries, project);
    }
}
