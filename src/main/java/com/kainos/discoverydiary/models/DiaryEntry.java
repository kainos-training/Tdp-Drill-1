package com.kainos.discoverydiary.models;

import java.sql.Time;
import java.util.Date;

/**
 * DiaryEntry object
 */
public class DiaryEntry {
    private SessionType sessionType;
    private String title;
    private Date startDate;
    private Time startTime;
    private String sessionGoal;

    public DiaryEntry(SessionType sessionType, String title, Date startDate, Time startTime, String sessionGoal) {
        this.sessionType = sessionType;
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.sessionGoal = sessionGoal;
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

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public String getSessionGoal() {
        return this.sessionGoal;
    }

    public void setSessionGoal(String sessionGoal) {
        this.sessionGoal = sessionGoal;
    }
}
