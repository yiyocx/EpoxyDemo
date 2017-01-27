package com.example.yiyo.epoxydemo;

import com.example.yiyo.epoxydemo.adapters.MainAdapter;
import com.example.yiyo.epoxydemo.rest.ServiceGenerator;
import com.example.yiyo.epoxydemo.rest.models.Photo;
import com.example.yiyo.epoxydemo.rest.services.UnsplashService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainViewModel {

    private MainActivity view;
    private MainAdapter mainAdapter;

    public MainViewModel(MainActivity view) {
        this.view = view;
        mainAdapter = new MainAdapter();
    }

    public void loadCollections() {
        ServiceGenerator.createService(UnsplashService.class).getAllPhotos()
                .map(new Func1<List<Photo>, Map<String, List<Photo>>>() {
                    @Override
                    public Map<String, List<Photo>> call(List<Photo> photos) {
                        Map<String, List<Photo>> authorsWithPhotos = new HashMap<>();
                        for (Photo photo : photos) {
                            if (authorsWithPhotos.containsKey(photo.author)) {
                                List<Photo> photosOfAuthor = new ArrayList<>(authorsWithPhotos.get(photo.author));
                                photosOfAuthor.add(photo);
                                authorsWithPhotos.put(photo.author, photosOfAuthor);
                            } else {
                                authorsWithPhotos.put(photo.author, Arrays.asList(photo));
                            }
                        }
                        return authorsWithPhotos;
                    }
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Map<String, List<Photo>>>() {
                    @Override
                    public void call(Map<String, List<Photo>> authorsAndPhotos) {
                        mainAdapter.addPhotos(authorsAndPhotos);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    public MainAdapter getMainAdapter() {
        return mainAdapter;
    }
}
