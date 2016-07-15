package com.kainos.discoverydiary.resources;

import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.models.DiaryEntry;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.models.SessionType;
import com.kainos.discoverydiary.views.DiaryEntryListView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

        DiaryEntry diaryEntry = new DiaryEntry(sessionType, title, startDate, startTime, sessionGoal, projectId);
        dataStore.addDiaryEntry(diaryEntry);

        // Act
        DiaryEntryListView returnedView = (DiaryEntryListView) diaryResource.listDiaryEntries(projectId);
        List<DiaryEntry> entries = returnedView.getEntries();

        // Assert
        Assert.assertTrue(entries.contains(diaryEntry));
    }

    @Test
    public void listDiaryEntries_whenOlderDiaryEntryAdded_entriesShouldBeReordered() {
        // Arrange
        int projectId = 1;
        final String projectName = "Test project name";
        final String projectDescription = "Test project desc";

        dataStore.AddProject(new Project(projectId, projectName, projectDescription));

        // Add first, newer data entry
        SessionType sessionType = SessionType.NFRs;
        String title1 = "Data Entry 1";
        String startDate = "18/06/2016";
        String startTime = "16:00:00";
        String sessionGoal = "Test 1";

        DiaryEntry diaryEntry1 = new DiaryEntry(sessionType, title1, startDate, startTime, sessionGoal, projectId);
        dataStore.addDiaryEntry(diaryEntry1);

        // Add second, older data entry
        sessionType = SessionType.NFRs;
        String title2 = "NFR workshop";
        startDate = "10/06/2016";
        startTime = "16:00:00";
        sessionGoal = "Test 1";

        DiaryEntry diaryEntry2 = new DiaryEntry(sessionType, title2, startDate, startTime, sessionGoal, projectId);
        dataStore.addDiaryEntry(diaryEntry2);

        // Act
        DiaryEntryListView returnedView = (DiaryEntryListView) diaryResource.listDiaryEntries(projectId);
        List<DiaryEntry> entries = returnedView.getEntries();

        // Assert
        Assert.assertEquals(entries.get(0).getTitle(), title2);
    }
}
