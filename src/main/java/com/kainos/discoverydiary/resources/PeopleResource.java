package com.kainos.discoverydiary.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;
import com.kainos.discoverydiary.DataStore;
import com.kainos.discoverydiary.config.DiscoveryDiaryConfiguration;
import com.kainos.discoverydiary.models.Person;
import com.kainos.discoverydiary.views.PeopleAddView;
import com.kainos.discoverydiary.views.PeopleListView;
import io.dropwizard.views.View;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Strings;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("people")
public class PeopleResource {

    final static Logger LOGGER = LoggerFactory.getLogger(PeopleResource.class);

    final DataStore dataStore;
    final DiscoveryDiaryConfiguration configuration;

    public PeopleResource(DataStore dataStore, DiscoveryDiaryConfiguration configuration) {
        this.dataStore = dataStore;
        this.configuration = configuration;
    }

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View index(){
        return new PeopleListView(dataStore.getPeople());
    }

    @Path("add")
    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View add(){
        return new PeopleAddView(new ArrayList<String>());
    }

    @Path("add")
    @POST
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public View addPerson(
            @FormDataParam("name") String name,
            @FormDataParam("age") Integer age,
            @FormDataParam("profilePicture") InputStream file,
            @FormDataParam("profilePicture") FormDataContentDisposition fileMetaData
    ){

        List<String> errors = Lists.newArrayList();

        if (Strings.isNullOrEmpty(name)) {
            errors.add("Enter a valid name");
        }

        if (age == null || age < 0 || age > 120) {
            errors.add("Enter a valid age between 1 and 120");
        }

        if (!errors.isEmpty()) {
            return new PeopleAddView(errors);
        }

        UUID idForNewPerson = UUID.randomUUID();

        // creating path for image and storing the image with the id of the person plus the image file extension
        String imagesPath = configuration.getProfileImagesFilePath();

        if (!imagesPath.endsWith("/")) {
            imagesPath += "/";
        }

        String profilePictureName = idForNewPerson.toString() + "." + com.google.common.io.Files.getFileExtension(fileMetaData.getFileName());
        String profileImageUploadPathAndFileName = imagesPath + "/" + profilePictureName;

        try {
            Files.createDirectories(Paths.get(imagesPath));

            LOGGER.info("Profile picture being saved as " + profileImageUploadPathAndFileName);

            int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(new File(profileImageUploadPathAndFileName));
            while ((read = file.read(bytes)) != -1)
            {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            LOGGER.error("Error uploading file", e);
            throw new WebApplicationException("Error while uploading file.");
        }

        dataStore.registerPerson(idForNewPerson, name, age, profilePictureName);

        URI peopleListUri = UriBuilder.fromUri("/people").build();
        Response response = Response.seeOther(peopleListUri).build();
        throw new WebApplicationException(response); // valid way to redirect in dropwizard
    }
}

