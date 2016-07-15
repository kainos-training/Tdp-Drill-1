package com.kainos.discoverydiary.resources;

import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.models.DiaryEntry;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.models.SessionType;
import com.kainos.discoverydiary.views.DiaryEntryListView;
import io.dropwizard.views.View;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulwr on 15/07/2016.
 */
public class DiaryResourceTest {
    private DiaryResource diaryResource;
    private DataStore dataStore;

    @Before
    public void setup(){
        dataStore = new DataStore();
        diaryResource = new DiaryResource(dataStore);
    }

    @Test
    public void listDiaryEntries_whenDiaryEntryAdded_returnsViewWithEntryContained() {
        // Arrange
        int projectId = 1;
        final String projectName = "Test project name";
        final String projectDescription = "Test project desc";
        dataStore.AddProject(new Project(projectId, projectName, projectDescription));

        SessionType sessionType = SessionType.NFRs;
        String title = "Test Data Entry";
        String startDate = "18/06/2016";
        String startTime = "16:00:00";
        String sessionGoal = "Test 1";

        // Act
        DiaryEntry diaryEntry = new DiaryEntry(sessionType, title, startDate, startTime, sessionGoal);
        dataStore.addDiaryEntry(diaryEntry);

        DiaryEntryListView returnedView = (DiaryEntryListView) diaryResource.listDiaryEntries(projectId);
        List<DiaryEntry> entries = returnedView.getEntries();

        // Assert
        Assert.assertTrue(entries.contains(diaryEntry));
    }
}
