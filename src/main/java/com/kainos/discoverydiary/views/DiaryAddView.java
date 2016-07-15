package com.kainos.discoverydiary.views;


import com.kainos.discoverydiary.models.Project;
import io.dropwizard.views.View;

import java.util.List;

public class DiaryAddView extends View {

    private final List<String> errors;

    private final Project project;

    public DiaryAddView(List<String> errors, Project project) {
        super("/Views/diary/addDiary.ftl");
        this.errors = errors;
        this.project = project;
    }

    public List<String> getErrors() {
        return errors;
    }

    public Project getProject() { return project; }

}
