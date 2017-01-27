package com.example.yiyo.epoxydemo.models;

import com.airbnb.epoxy.EpoxyModel;
import com.example.yiyo.epoxydemo.R;
import com.example.yiyo.epoxydemo.rest.models.Photo;
import com.example.yiyo.epoxydemo.views.AuthorPhotosView;

import java.util.List;

public class AuthorPhotosModel extends EpoxyModel<AuthorPhotosView> {

    private String authorName;
    private List<Photo> photos;

    public AuthorPhotosModel(String authorName, List<Photo> photos) {
        this.authorName = authorName;
        this.photos = photos;
    }

    @Override
    public void bind(AuthorPhotosView authorPhotosView) {
        authorPhotosView.setAuthor(authorName);
        authorPhotosView.setPhotos(photos);
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.view_model_author_photos;
    }

    @Override
    public boolean shouldSaveViewState() {
        return true;
    }
}
