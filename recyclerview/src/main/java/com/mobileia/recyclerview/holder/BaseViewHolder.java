package com.mobileia.recyclerview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by matiascamiletti on 15/10/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    /**
     * Constructor base
     * @param itemView
     */
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Metodo que se usa para cargar los datos del objeto
     * @param object
     */
    public abstract void bind(T object);
}
