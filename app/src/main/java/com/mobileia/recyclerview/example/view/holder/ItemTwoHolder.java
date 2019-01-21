package com.mobileia.recyclerview.example.view.holder;

import android.view.View;
import android.widget.TextView;

import com.mobileia.recyclerview.example.R;
import com.mobileia.recyclerview.example.entity.ItemTestTwo;
import com.mobileia.recyclerview.holder.BaseViewHolder;

public class ItemTwoHolder extends BaseViewHolder<ItemTestTwo> {

    public final TextView titleView;
    public final TextView subtitleView;

    public ItemTwoHolder(View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.text_title);
        subtitleView = itemView.findViewById(R.id.text_subtitle);
    }

    @Override
    public void bind(ItemTestTwo object) {
        titleView.setText(object.title);
        subtitleView.setText(object.subtitle);
    }
}