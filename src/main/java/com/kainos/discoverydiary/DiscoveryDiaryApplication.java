package com.kainos.discoverydiary;

import com.github.dirkraft.dropwizard.fileassets.FileAssetsBundle;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
import com.kainos.discoverydiary.resources.DiaryResource;
import com.kainos.discoverydiary.resources.HomeResource;
import com.kainos.discoverydiary.resources.PeopleResource;
import com.kainos.discoverydiary.resources.ProjectResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class DiscoveryDiaryApplication extends Application<DiscoveryDiaryConfiguration> {
    @Override
    public void initialize(Bootstrap<DiscoveryDiaryConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<DiscoveryDiaryConfiguration>());
        bootstrap.addBundle(new AssetsBundle("/assets", "/assets"));
        bootstrap.addBundle(new FileAssetsBundle("profilePics", "/profilePics"));
        bootstrap.addBundle(new MultiPartBundle());
    }

    public void run(DiscoveryDiaryConfiguration discoveryDiaryConfiguration, Environment environment) throws Exception {
        final HomeResource homeResource = new HomeResource();
        final PeopleResource peopleResource = new PeopleResource(new DataStore(), discoveryDiaryConfiguration);
        final DiaryResource diaryResource = new DiaryResource(new DataStore(), discoveryDiaryConfiguration);

        environment.jersey().register(homeResource);
        environment.jersey().register(peopleResource);
        environment.jersey().register(diaryResource);

        final ProjectResource projectResource = new ProjectResource(new DataStore(), discoveryDiaryConfiguration);

        environment.jersey().register(projectResource);
    }

    public static void main(String[] args) throws Exception {
        new DiscoveryDiaryApplication().run(args);
    }
}
