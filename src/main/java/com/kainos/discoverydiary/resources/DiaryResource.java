package com.kainos.discoverydiary.resources;

import com.codahale.metrics.annotation.Timed;
import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
import com.kainos.discoverydiary.models.DiaryEntry;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.models.SessionType;
import com.kainos.discoverydiary.views.DiaryAddView;
import com.kainos.discoverydiary.views.DiaryEntryListView;
import com.kainos.discoverydiary.views.DiaryReadOnlyView;
import io.dropwizard.views.View;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Resource file for routing Diary Entry requests
 */
@Path("project")
public class DiaryResource {
    final DataStore dataStore;

    public DiaryResource(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Path("{projectId}/diary")
    @GET
    public View listDiaryEntries(@PathParam("projectId") int projectId) {
        Project project = dataStore.getProject(projectId);
        List<DiaryEntry> entries = dataStore.getEntries();
        
        return new DiaryEntryListView(entries, project);
    }

    @Path("{projectId}/diary/add")
    @GET
    public View addDiary(@PathParam("projectId") int projectId) {
        Project project = dataStore.getProject(projectId);
        return new DiaryAddView(new ArrayList<String>(), project);
    }

    @Path("{projectId}/diary/add")
    @POST
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public View saveDiary(@PathParam("projectId") int projectId,
                          @FormDataParam("title") String title,
                          @FormDataParam("category") String category,
                          @FormDataParam("date") String date,
                          @FormDataParam("startTime") String startTime,
                          @FormDataParam("endTime") String endTime,
                          @FormDataParam("sessionGoal") String sessionGoal) {

        Project project = dataStore.getProject(projectId);

        SessionType sessionType;

        if(category.equals(SessionType.GOALS.toString()))
        {
            sessionType = SessionType.GOALS;
        } else if(category.equals(SessionType.NFRs.toString()))
        {
            sessionType = SessionType.NFRs;
        } else if(category.equals(SessionType.USER_STORY_CREATION.toString()))
        {
            sessionType = SessionType.USER_STORY_CREATION;
        } else if(category.equals(SessionType.OTHER.toString()))
        {
            sessionType = SessionType.OTHER;
        } else {
            sessionType = SessionType.OTHER;
        }

        DiaryEntry diaryEntry = new DiaryEntry(sessionType, title, date, startTime, sessionGoal);

        dataStore.addDiaryEntry(diaryEntry);

        return new DiaryReadOnlyView(diaryEntry, project);

    }

}
