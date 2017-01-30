package com.example.yiyo.epoxydemo.groupie;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yiyo.epoxydemo.R;
import com.example.yiyo.epoxydemo.databinding.ActivityMainGroupieBinding;

public class MainGroupieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainGroupieBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_groupie);
        MainGroupieViewModel viewModel = new MainGroupieViewModel();
        binding.setViewModel(viewModel);
        binding.recycler.setAdapter(viewModel.getAdapter());
        viewModel.loadPhotos();
    }
}
