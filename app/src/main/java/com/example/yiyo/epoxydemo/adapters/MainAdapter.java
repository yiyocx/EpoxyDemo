package com.example.yiyo.epoxydemo.adapters;

import com.airbnb.epoxy.EpoxyAdapter;
import com.airbnb.epoxy.SimpleEpoxyModel;
import com.example.yiyo.epoxydemo.R;
import com.example.yiyo.epoxydemo.models.AuthorPhotosModel;
import com.example.yiyo.epoxydemo.rest.models.Photo;

import java.util.List;
import java.util.Map;

public class MainAdapter extends EpoxyAdapter {

    public MainAdapter() {
        enableDiffing();
        addModel(new SimpleEpoxyModel(R.layout.view_header));
    }

    public void addPhotos(Map<String, List<Photo>> photos) {
        for (Map.Entry<String, List<Photo>> entry: photos.entrySet()) {
            addModel(new AuthorPhotosModel(entry.getKey(), entry.getValue()));
        }
        notifyModelsChanged();
    }
}
