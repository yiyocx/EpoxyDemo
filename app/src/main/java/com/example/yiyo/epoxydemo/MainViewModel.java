package com.example.yiyo.epoxydemo;

import com.example.yiyo.epoxydemo.rest.ServiceGenerator;
import com.example.yiyo.epoxydemo.rest.models.Photo;
import com.example.yiyo.epoxydemo.rest.services.UnsplashService;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainViewModel {

    private MainActivity view;
    private PhotoAdapter photoAdapter;

    public MainViewModel(MainActivity view) {
        this.view = view;
        photoAdapter = new PhotoAdapter();
    }

    public void loadCollections() {
        ServiceGenerator.createService(UnsplashService.class).getAllPhotos()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Photo>>() {
                    @Override
                    public void call(List<Photo> photos) {
                        photoAdapter.addPhotos(photos);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    public PhotoAdapter getPhotoAdapter() {
        return photoAdapter;
    }
}
