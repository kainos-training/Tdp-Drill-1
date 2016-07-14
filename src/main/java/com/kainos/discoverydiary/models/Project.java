package com.kainos.discoverydiary.models;

/**
 * Created by seand on 14/07/2016.
 */
public class Project {

    private static int NEXT_ID = 1;

    private int id;
    private String name;
    private String description;

    /*
    Create a new project
    name - Name of the project
    description - Description of the project
    */
    public Project(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    /*
    Get the id of the given project
     */
    public int getId() {
        return id;
    }

    /*
    Get the name of the given project
     */
    public String getName() {
        return name;
    }

    /*
    Get the description of the given project
     */
    public String getDescription() {
        return description;
    }


}
