package com.mobileia.recyclerview.controller;

import android.view.View;

import com.mobileia.recyclerview.holder.BaseViewHolder;

/**
 * Created by matiascamiletti on 9/2/18.
 */

public class BaseViewController {
    /**
     * Almacena el ViewHolder de esta vista controlador
     */
    protected BaseViewHolder mViewHolder;

    /**
     * Constructor
     * @param view
     */
    public BaseViewController(View view){}

    /**
     * Funcion que devuelve la vista del controlador
     * @return
     */
    public View getView(){
        return mViewHolder.getView();
    }
}
