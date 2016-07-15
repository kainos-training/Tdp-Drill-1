package com.kainos.discoverydiary.models;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * DiaryEntry object
 */
public class DiaryEntry {
    private SessionType sessionType;
    private String title;
    private String startDate;
    private String startTime;
    private String sessionGoal;
    private int diaryId;

    public DiaryEntry(SessionType sessionType, String title, String startDate, String startTime, String sessionGoal) {

        this.sessionType = sessionType;
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.sessionGoal = sessionGoal;
    }

    public int getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(int id) {
        this.diaryId = id;
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
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");
        return DateTime.parse(startDate+ " "+startTime, formatter);
    }
}
