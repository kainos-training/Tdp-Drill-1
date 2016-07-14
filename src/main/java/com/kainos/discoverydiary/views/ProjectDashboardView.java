package com.kainos.discoverydiary.views;

import com.kainos.discoverydiary.models.Project;
import io.dropwizard.views.View;

/**
 * Created by seand on 14/07/2016.
 */
public class ProjectDashboardView extends View {

    private Project project;

    public ProjectDashboardView(Project project){
        super("/Views/project/view.ftl");
        this.project = project;
    }

    public Project getProject(){
        return project;
    }
}
