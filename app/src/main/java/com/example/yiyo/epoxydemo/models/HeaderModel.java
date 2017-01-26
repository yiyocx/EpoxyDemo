package com.example.yiyo.epoxydemo.models;

import android.support.annotation.LayoutRes;

import com.airbnb.epoxy.EpoxyModel;
import com.example.yiyo.epoxydemo.R;

public class HeaderModel extends EpoxyModel {

    @Override
    public void bind(Object view) {
        super.bind(view);
    }

    @Override
    public void unbind(Object view) {
        super.unbind(view);
    }

    @LayoutRes
    @Override
    protected int getDefaultLayout() {
        return R.layout.view_header;
    }
}
