package com.kainos.discoverydiary.resources;

import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.models.Project;
import com.kainos.discoverydiary.views.ProjectDashboardView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by christopherg on 14/07/2016.
 */
public class ProjectResourceTest {

    private ProjectResource projectResource;
    private DataStore dataStore;

    @Before
    public void setup(){
        dataStore = new DataStore();
        projectResource = new ProjectResource(dataStore);
    }

    @Test
    public void index_whenProvidedWithMatchingProjectId_RetrievesProjectFromStore(){
        // Arrange
        final String projectName = "Test project name";
        final String projectDescription = "Test project desc";

        dataStore.AddProject(new Project(1, projectName, projectDescription));

        // Act
        ProjectDashboardView result = (ProjectDashboardView)projectResource.index(1);

        // Assert
        assertTrue(result.getProject().getId() == 1);
        assertTrue(result.getProject().getName() == projectName);
        assertTrue(result.getProject().getDescription() == projectDescription);
        assertTrue(result.getTemplateName() == "/Views/project/view.ftl");
    }

}
