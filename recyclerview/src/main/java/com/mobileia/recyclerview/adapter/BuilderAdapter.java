package com.mobileia.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileia.recyclerview.holder.BaseViewHolder;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by matiascamiletti on 15/10/17.
 */

public class BuilderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**
     * Almacena los objetos del adapter
     */
    protected ArrayList<Object> mValues = new ArrayList<>();
    /**
     * Almacena la clase del ViewHolder del listado
     */
    protected Class<?> mViewHolder;
    /**
     * Almacena el layout del item
     */
    protected int mLayout;

    /**
     * Constructor basico
     */
    public BuilderAdapter(){}

    /**
     * Constructor con el viewHolder
     * @param layout
     * @param baseViewHolder
     */
    public BuilderAdapter(int layout, Class<?> baseViewHolder){
        setViewHolder(layout, baseViewHolder);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);

        try {
            // Generamos el viewHolder
            return (BaseViewHolder)mViewHolder.getConstructor(View.class).newInstance(view);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder baseHolder = (BaseViewHolder)holder;
        baseHolder.bind(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    /**
     * Setea la clase del viewHolder a usar
     * @param layout
     * @param baseViewHolder
     */
    public void setViewHolder(int layout, Class<?> baseViewHolder){
        mLayout = layout;
        mViewHolder = baseViewHolder;
    }

    /**
     * Funcion para agregar un objeto al listado
     * @param object
     */
    public void add(Object object){
        mValues.add(object);
        notifyDataSetChanged();
    }
    /**
     * Funcion para agregar un objeto al listado
     * @param index
     * @param object
     */
    public void add(int index, Object object){
        mValues.add(index, object);
        notifyDataSetChanged();
    }

    /**
     * Funcino para agregar un listado de objetos
     * @param list
     */
    public void add(ArrayList<Object> list){
        mValues.addAll(list);
        notifyDataSetChanged();
    }
}
