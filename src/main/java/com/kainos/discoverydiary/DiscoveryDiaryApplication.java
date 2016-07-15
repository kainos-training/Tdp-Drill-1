package com.kainos.discoverydiary;

import com.github.dirkraft.dropwizard.fileassets.FileAssetsBundle;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
import com.kainos.discoverydiary.models.Person;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.resources.ContactResource;
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
        dataStore.addContact(1, 1, "Sean Devlin", "Graduate Software Engineer", "Kainos",
                "s.devlin2@kainos.com", "02890947271", "07703848293");
        dataStore.addContact(1, 2, "Adam Kane", "Graduate Software Engineer", "Kainos",
                "a.kane@kainos.com", "02878473829", "07794872838");

        final PeopleResource peopleResource = new PeopleResource(dataStore, discoveryDiaryConfiguration);
        final ProjectResource projectResource = new ProjectResource(dataStore);
        final ContactResource contactResource = new ContactResource(dataStore);

        environment.jersey().register(peopleResource);
        environment.jersey().register(projectResource);
        environment.jersey().register(contactResource);
    }

    public static void main(String[] args) throws Exception {
        new DiscoveryDiaryApplication().run(args);
    }
}
