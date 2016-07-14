package com.kainos.discoverydiary.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class DiscoveryDiaryConfiguration extends Configuration {

    @NotNull
    private ImmutableMap<String, ImmutableMap<String, String>> viewRendererConfiguration = ImmutableMap.of();

    @NotEmpty
    private String profileImagesFilePath;

    @JsonProperty
    public String getProfileImagesFilePath() {
        return profileImagesFilePath;
    }

    @JsonProperty
    public void setProfileImagesFilePath(String profileImagesFilePath) {
        this.profileImagesFilePath = profileImagesFilePath;
    }
}
