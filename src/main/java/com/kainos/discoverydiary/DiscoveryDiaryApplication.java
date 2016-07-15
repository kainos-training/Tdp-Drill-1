package com.kainos.discoverydiary;

import com.github.dirkraft.dropwizard.fileassets.FileAssetsBundle;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
import com.kainos.discoverydiary.models.DiaryEntry;
import com.kainos.discoverydiary.models.SessionType;
import com.kainos.discoverydiary.resources.DiaryResource;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.resources.PeopleResource;
import com.kainos.discoverydiary.resources.ProjectResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class DiscoveryDiaryApplication extends Application<DiscoveryDiaryConfiguration> {
    private DataStore dataStore;

    @Override
    public void initialize(Bootstrap<DiscoveryDiaryConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<DiscoveryDiaryConfiguration>());
        bootstrap.addBundle(new AssetsBundle("/assets", "/assets"));
        bootstrap.addBundle(new FileAssetsBundle("profilePics", "/profilePics"));
        bootstrap.addBundle(new MultiPartBundle());
    }

    public void run(DiscoveryDiaryConfiguration discoveryDiaryConfiguration, Environment environment) throws Exception {
        dataStore = new DataStore();
        dataStore.AddProject(new Project(1, "Government", "This is a sample project and we do no care about the content of " +
                "this sentence."));
        dataStore.AddProject(new Project(2, "Scottish Courts", "Scottish court service to allow management of cases"));

        dataStore.addDiaryEntry(new DiaryEntry(SessionType.VISION, "Diary Entry 1", "18/06/2016", "16:00:00", "Session goal 1", 1));
        dataStore.addDiaryEntry(new DiaryEntry(SessionType.GOALS, "Diary Entry 2",  "21/06/2016", "17:00:00", "Session goal 2", 1));
        dataStore.addDiaryEntry(new DiaryEntry(SessionType.NFRs, "Diary Entry 3", "02/06/2016", "18:00:00", "Session goal 3", 1));

        final PeopleResource peopleResource = new PeopleResource(dataStore, discoveryDiaryConfiguration);
        final ProjectResource projectResource = new ProjectResource(dataStore);
        final DiaryResource diaryResource = new DiaryResource(dataStore);


        environment.jersey().register(peopleResource);
        environment.jersey().register(diaryResource);

        environment.jersey().register(projectResource);
    }

    public static void main(String[] args) throws Exception {
        new DiscoveryDiaryApplication().run(args);
    }
}
