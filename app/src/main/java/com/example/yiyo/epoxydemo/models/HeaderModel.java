package com.example.yiyo.epoxydemo.models;

import android.support.annotation.LayoutRes;

import com.airbnb.epoxy.EpoxyModel;
import com.example.yiyo.epoxydemo.R;

public class HeaderModel extends EpoxyModel {

    @LayoutRes
    @Override
    protected int getDefaultLayout() {
        return R.layout.view_header;
    }
}
