package com.kainos.discoverydiary.resources;

import com.codahale.metrics.annotation.Timed;

import com.kainos.discoverydiary.views.DiaryAddView;

import io.dropwizard.views.View;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("diary")
public class DiaryResource {

    public DiaryResource() {

    }

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Path("add")
    public View index(){
        return new DiaryAddView();
    }

}
