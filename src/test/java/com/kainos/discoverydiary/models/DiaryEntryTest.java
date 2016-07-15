package com.kainos.discoverydiary.models;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Time;
import java.util.Date;

/**
 * DiaryEntry object tests
 */
public class DiaryEntryTest {

    /**
     * Test that we can create a new DiaryEntry with valid data
     * The getters should return the same data we used to create the object
     */
    @Test
    public void DiaryEntry_validData_gettersReturnCorrectData() {
        // Arrange
        SessionType sessionType = SessionType.NFRs;
        String title = "Test Data Entry";
        String startDate = "18/06/2016";
        String startTime = "16:00:00";
        String sessionGoal = "Test 1";

        // Act
        DiaryEntry diaryEntry = new DiaryEntry(sessionType, title, startDate, startTime, sessionGoal);

        // Assert
        Assert.assertEquals(diaryEntry.getTitle(), title);
        Assert.assertEquals(diaryEntry.getStartDate(), startDate);
        Assert.assertEquals(diaryEntry.getStartTime(), startTime);
        Assert.assertEquals(diaryEntry.getSessionGoal(), sessionGoal);
        Assert.assertEquals(diaryEntry.getSessionType(), sessionType);
    }

    @Test
    public void returns_list_of_tags(){

        SessionType sessionType = SessionType.NFRs;
        String title = "Test Data Entry";
        String startDate = "18/06/2016";
        String startTime = "16:00:00";
        String sessionGoal = "Test 1";

        // Act
        DiaryEntry diaryEntry = new DiaryEntry(sessionType, title, startDate, startTime, sessionGoal, "bob,bob2,bob3,bob4");

        Assert.assertEquals(diaryEntry.getTags().get(0), "bob");

    }
}
