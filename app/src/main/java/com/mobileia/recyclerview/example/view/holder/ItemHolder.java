package com.mobileia.recyclerview.example.view.holder;

import android.view.View;
import android.widget.TextView;

import com.mobileia.recyclerview.example.R;
import com.mobileia.recyclerview.example.entity.ItemTest;
import com.mobileia.recyclerview.holder.BaseViewHolder;

/**
 * Created by matiascamiletti on 15/10/17.
 */

public class ItemHolder extends BaseViewHolder<ItemTest> {

    public final TextView titleView;
    public final TextView subtitleView;

    public ItemHolder(View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.text_title);
        subtitleView = itemView.findViewById(R.id.text_subtitle);
    }

    @Override
    public void bind(ItemTest object) {
        titleView.setText(object.title);
        subtitleView.setText(object.subtitle);
    }
}
