package com.example.yiyo.epoxydemo.epoxy.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yiyo.epoxydemo.R;
import com.example.yiyo.epoxydemo.epoxy.adapters.AuthorPhotosAdapter;
import com.example.yiyo.epoxydemo.rest.models.Photo;

import java.util.List;

public class AuthorPhotosView extends LinearLayout {

    private TextView authorTextView;
    private RecyclerView recyclerViewPhotos;
    private AuthorPhotosAdapter photosAdapter;

    public AuthorPhotosView(Context context) {
        super(context);
        init();
    }

    public AuthorPhotosView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AuthorPhotosView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.item_author_photos, this);
        authorTextView = (TextView) findViewById(R.id.textView_author);
        recyclerViewPhotos = (RecyclerView) findViewById(R.id.recyclerView_photos);
        photosAdapter = new AuthorPhotosAdapter();
        recyclerViewPhotos.setAdapter(photosAdapter);
    }

    public void setAuthor(String author) {
        authorTextView.setText(author);
    }

    public void setPhotos(List<Photo> photos) {
        photosAdapter.addPhotos(photos);
    }
}
