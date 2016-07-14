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
        DiaryEntry diaryEntry = new DiaryEntry(SessionType.NFRs, "Test Data Entry", new Date(2016,07,01), new Time(15,00,00), "Goal 1");
        Assert.assertEquals(diaryEntry.getTitle(),"Test Data Entry");
    }
}
