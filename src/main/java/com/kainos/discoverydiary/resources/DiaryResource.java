package com.kainos.discoverydiary.resources;

import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
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
        return new DiaryEntryListView(dataStore.getEntries());
    }
}
