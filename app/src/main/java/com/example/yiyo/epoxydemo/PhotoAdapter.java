package com.example.yiyo.epoxydemo;

import com.airbnb.epoxy.EpoxyAdapter;
import com.example.yiyo.epoxydemo.models.HeaderModel;
import com.example.yiyo.epoxydemo.rest.models.Photo;

import java.util.List;

public class PhotoAdapter extends EpoxyAdapter {

    public PhotoAdapter() {
        addModel(new HeaderModel());
    }

    public void addPhotos(List<Photo> photos) {

    }
}
