package com.kainos.discoverydiary.views;

import com.kainos.discoverydiary.models.DiaryEntry;
import io.dropwizard.views.View;

import java.util.List;

/**
 * Created by paulwr on 14/07/2016.
 */
public class DiaryEntryListView extends View {
    private final List<DiaryEntry> entries;

    public DiaryEntryListView(List<DiaryEntry> entries) {
        super("/Views/diary/diaryEntriesList.ftl");
        this.entries = entries;
    }

    public List<DiaryEntry> getEntries() { return entries; }
}
