package com.kainos.discoverydiary.models;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DiaryEntry object
 */
public class DiaryEntry {
    private SessionType sessionType;
    private String title;
    private String startDate;
    private String startTime;
    private String sessionGoal;
    private String tags;

    public DiaryEntry(SessionType sessionType, String title, String startDate, String startTime, String sessionGoal) {
        this.sessionType = sessionType;
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.sessionGoal = sessionGoal;
    }

    public DiaryEntry(SessionType sessionType, String title, String startDate, String startTime, String sessionGoal, String tags) {
        this.sessionType = sessionType;
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.sessionGoal = sessionGoal;
        this.tags = tags;
    }

    public SessionType getSessionType() {
        return this.sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSessionGoal() {
        return this.sessionGoal;
    }

    public void setSessionGoal(String sessionGoal) {
        this.sessionGoal = sessionGoal;
    }

    public DateTime getSessionDateAndTime(){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        return DateTime.parse(startDate+ " "+startTime, formatter);
    }

    public List<String> getTags() {
        List<String> seperatedTags = Arrays.asList(tags.split(", "));
        return seperatedTags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
