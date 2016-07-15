package com.kainos.discoverydiary.models;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * DiaryEntry object
 */
public class DiaryEntry {

    final String DEFAULT_IMAGE_URL="http://i.imgur.com/BbpaP7N.png";
    private SessionType sessionType;
    private int diaryId;
    private String title;
    private String startDate;
    private String startTime;
    private String sessionGoal;
    private String imageUrl;
    private int projectID;

    
    public DiaryEntry(SessionType sessionType, String title, String startDate, String startTime, String sessionGoal,
                      int projectID) {
        this.sessionType = sessionType;
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.sessionGoal = sessionGoal;
        this.projectID = projectID;
    }

    public DiaryEntry(SessionType sessionType, String title, String startDate, String startTime, String sessionGoal,
                      int projectID, String imageUrl) {
        this.sessionType = sessionType;
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.sessionGoal = sessionGoal;
        this.imageUrl = imageUrl;
        this.projectID = projectID;
    }

    public int getDiaryId() {
        return  diaryId;
    }

    public void setDiaryId(int diaryId) {
        this.diaryId = diaryId;
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

    public String getImageUrl() {
        if (imageUrl.equals(""))
            return DEFAULT_IMAGE_URL;
        else
            return imageUrl;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
}
