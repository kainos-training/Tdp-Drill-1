package com.kainos.discoverydiary.views;

import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.models.DiaryEntry;
import com.kainos.discoverydiary.models.Project;
import io.dropwizard.views.View;

public class DiaryReadOnlyView extends View {

    private final DiaryEntry diaryEntry;
    private final Project project;

    public DiaryReadOnlyView(DiaryEntry diaryEntry, Project project) {
        super("/Views/diary/diaryReadOnlyView.ftl");
        this.diaryEntry = diaryEntry;
        this.project = project;
    }

}
