package com.mobileia.recyclerview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by matiascamiletti on 15/10/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    /**
     * Almacena el adapter
     */
    protected RecyclerView.Adapter mAdapter;
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

    /**
     * Funcion para refrescar el adapter
     */
    public void notifyDataSetChanged(){
        mAdapter.notifyDataSetChanged();
    }

    /**
     * Metodo para configurar el adapter
     * @param adapter
     */
    public void setAdapter(RecyclerView.Adapter adapter){
        mAdapter = adapter;
    }

    /**
     * Metodo para obtener el adapter configurado
     * @return
     */
    public RecyclerView.Adapter getAdapter(){ return mAdapter; }

    /**
     * Funcion para obtener la vista
     * @return
     */
    public View getView(){ return itemView; }
}
