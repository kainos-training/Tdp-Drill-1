package com.kainos.discoverydiary.views;


import io.dropwizard.views.View;

import java.util.List;

public class DiaryAddView extends View {

    private final List<String> errors;

    public DiaryAddView(List<String> errors) {
        super("/Views/diary/addDiary.ftl");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

}
