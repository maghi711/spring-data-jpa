package com.maghi711.bootsecuritydemo.restclient;

import java.util.List;
import java.util.StringJoiner;

public class PackageResponse {

    private List<String> imageIdentities;

    public List<String> getImageIdentities() {
        return imageIdentities;
    }

    public void setImageIdentities(List<String> imageIdentities) {
        this.imageIdentities = imageIdentities;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PackageResponse.class.getSimpleName() + "[", "]")
                .add("imageIdentities=" + imageIdentities)
                .toString();
    }
}
