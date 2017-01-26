package com.example.yiyo.epoxydemo.rest.models;

import com.google.gson.annotations.SerializedName;

public class Photo {

    public String format;
    public int width;
    public int height;
    public String filename;
    public long id;
    public String author;

    @SerializedName("author_url")
    public String authorUrl;

    @SerializedName("post_url")
    public String postUrl;
}
