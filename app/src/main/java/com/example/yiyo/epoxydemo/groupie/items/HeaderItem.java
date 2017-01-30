package com.example.yiyo.epoxydemo.groupie.items;

import com.example.yiyo.epoxydemo.R;
import com.example.yiyo.epoxydemo.databinding.ItemHeaderBinding;
import com.genius.groupie.Item;

public class HeaderItem extends Item<ItemHeaderBinding> {

    private String title;

    public HeaderItem(String title) {
        this.title = title;
    }

    @Override
    public int getLayout() {
        return R.layout.item_header;
    }

    @Override
    public void bind(ItemHeaderBinding viewBinding, int position) {
        viewBinding.setText(title);
    }
}
