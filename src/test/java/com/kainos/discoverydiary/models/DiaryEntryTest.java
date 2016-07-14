package com.kainos.discoverydiary.models;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Time;
import java.util.Date;

/**
 * DiaryEntry object tests
 */
public class DiaryEntryTest {

    @Test
    public void DiaryEntry_validData_newDataEntryCreated() {
        DiaryEntry diaryEntry = new DiaryEntry(SessionType.NFRs, "Test Data Entry","", "", "Goal 1");
        Assert.assertEquals(diaryEntry.getTitle(),"Test Data Entry");
    }
}
