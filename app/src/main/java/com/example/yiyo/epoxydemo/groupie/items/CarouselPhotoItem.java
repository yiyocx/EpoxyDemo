package com.example.yiyo.epoxydemo.groupie.items;

import com.example.yiyo.epoxydemo.R;
import com.example.yiyo.epoxydemo.databinding.ItemSquarePhotoBinding;
import com.example.yiyo.epoxydemo.rest.models.Photo;
import com.genius.groupie.Item;
import com.squareup.picasso.Picasso;

public class CarouselPhotoItem extends Item<ItemSquarePhotoBinding> {

    private static final String PHOTO_URL = "https://unsplash.it/300/300?image=%s";
    private Photo photo;

    public CarouselPhotoItem(Photo photo) {
        this.photo = photo;
    }

    @Override
    public int getLayout() {
        return R.layout.item_square_photo;
    }

    @Override
    public void bind(ItemSquarePhotoBinding viewBinding, int position) {
        Picasso.with(viewBinding.getRoot().getContext())
            .load(String.format(PHOTO_URL, photo.id))
            .into(viewBinding.imageViewPhoto);
    }
}
