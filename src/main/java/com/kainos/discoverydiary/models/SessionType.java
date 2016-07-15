package com.kainos.discoverydiary.models;

/**
 * Category used when selecting the session type for each Diary Entry
 */
public enum SessionType {
    VISION("Vision"), GOALS("Goals"), USER_STORY_CREATION("User Story Creation"), NFRs("NFRs"), OTHER("Other");

    public String name;

    SessionType(String name){
        this.name = name;
    }
}