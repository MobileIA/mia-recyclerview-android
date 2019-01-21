package com.mobileia.recyclerview.holder;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.mobileia.recyclerview.action.ItemTypeClickListener;

/**
 * Created by matiascamiletti on 15/10/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    /**
     * Almacena el adapter
     */
    protected RecyclerView.Adapter mAdapter;
    /**
     * Almacena el listener del click
     */
    protected ItemTypeClickListener mOnClickListener;
    /**
     * Almacena el objeto para enviar por el click
     */
    protected T mObjectSaved;
    /**
     * Constructor base
     * @param itemView
     */
    public BaseViewHolder(View itemView) {
        super(itemView);
        // Configurar click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnClickListener != null){
                    mOnClickListener.onItemClick(view, mObjectSaved);
                }
            }
        });
    }

    /**
     * Para almacenar el objeto para el click
     * @param object
     */
    public void setObject(T object) {
        this.mObjectSaved = object;
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
     * Configura el click del item
     * @param listener
     */
    public void setOnItemTypeClickListener(ItemTypeClickListener listener){
        this.mOnClickListener = listener;
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
