package com.example.yiyo.epoxydemo.adapters;

import android.view.View;
import android.widget.ImageView;

import com.airbnb.epoxy.EpoxyAdapter;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.SimpleEpoxyModel;
import com.example.yiyo.epoxydemo.R;
import com.example.yiyo.epoxydemo.rest.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class AuthorPhotosAdapter extends EpoxyAdapter {

    public AuthorPhotosAdapter() {
        enableDiffing();
    }

    public void addPhotos(List<Photo> photos) {
        for (final Photo photo : photos) {
            addModel(new EpoxyModel<ImageView>() {

                @Override
                public void bind(ImageView imageView) {
                    String PHOTO_URL_BASE = "https://unsplash.it/%d?image=%d";
                    Picasso.with(imageView.getContext())
                            .load(String.format(Locale.getDefault(), PHOTO_URL_BASE, 250, photo.id))
                            .into(imageView);
                }

                @Override
                public void unbind(ImageView view) {
                    view.setImageResource(android.R.color.transparent);
                }

                @Override
                protected int getDefaultLayout() {
                    return R.layout.item_photo;
                }
            });
        }
        notifyModelsChanged();
    }
}
