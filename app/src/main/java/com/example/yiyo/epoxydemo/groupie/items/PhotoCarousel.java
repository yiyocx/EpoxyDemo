package com.example.yiyo.epoxydemo.groupie.items;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yiyo.epoxydemo.R;
import com.example.yiyo.epoxydemo.databinding.ItemPhotoCarouselBinding;
import com.example.yiyo.epoxydemo.rest.models.Photo;
import com.genius.groupie.GroupAdapter;
import com.genius.groupie.Item;

import java.util.ArrayList;
import java.util.List;

public class PhotoCarousel extends Item<ItemPhotoCarouselBinding> {

    private GroupAdapter adapter = new GroupAdapter();

    public PhotoCarousel(List<Photo> photos) {
        List<CarouselPhotoItem> carouselPhotoItems = new ArrayList<>();
        for (Photo photo : photos) {
            CarouselPhotoItem carouselPhoto = new CarouselPhotoItem(photo);
            carouselPhotoItems.add(carouselPhoto);
        }
        adapter.addAll(carouselPhotoItems);
    }

    @Override
    public int getLayout() {
        return R.layout.item_photo_carousel;
    }

    @Override
    public void bind(ItemPhotoCarouselBinding viewBinding, int position) {
        RecyclerView recyclerViewPhotos = viewBinding.recyclerViewPhotos;
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerViewPhotos.getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPhotos.setLayoutManager(layoutManager);
        recyclerViewPhotos.setAdapter(adapter);
    }
}

