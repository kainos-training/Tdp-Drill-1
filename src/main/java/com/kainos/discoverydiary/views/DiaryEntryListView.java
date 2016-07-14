package com.kainos.discoverydiary.views;

import com.kainos.discoverydiary.models.DiaryEntry;
import com.kainos.discoverydiary.models.Project;
import io.dropwizard.views.View;

import java.util.List;

/**
 * Created by paulwr on 14/07/2016.
 */
public class DiaryEntryListView extends View {
    private final List<DiaryEntry> entries;
    private final Project project;

    public DiaryEntryListView(List<DiaryEntry> entries, Project project) {
        super("/Views/diary/diaryEntriesList.ftl");
        this.entries = entries;
        this.project = project;
    }

    public List<DiaryEntry> getEntries() { return entries; }

    public Project getProject() {
        return project;
    }
}
