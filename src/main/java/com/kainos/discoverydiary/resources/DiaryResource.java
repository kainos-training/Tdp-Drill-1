package com.kainos.discoverydiary.resources;

import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.views.DiaryEntryListView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Resource file for routing Diary Entry requests
 */
@Path("diary")
public class DiaryResource {
    final DataStore dataStore;
    final DiscoveryDiaryConfiguration configuration;

    public DiaryResource(DataStore dataStore, DiscoveryDiaryConfiguration configuration) {
        this.dataStore = dataStore;
        this.configuration = configuration;
    }

    @Path("list")
    @GET
    public View listDiaryEntries() {
        Project project = new Project(1, "Government", "This is a sample project and we do no care about the content of " +
                "this sentence.");
        return new DiaryEntryListView(dataStore.getEntries(), project);
    }
}
