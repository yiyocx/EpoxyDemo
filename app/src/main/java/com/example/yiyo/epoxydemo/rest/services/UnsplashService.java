package com.example.yiyo.epoxydemo.rest.services;

import com.example.yiyo.epoxydemo.rest.models.Photo;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface UnsplashService {

    @GET("/list")
    Observable<List<Photo>> getAllPhotos();

}
