package com.mobileia.recyclerview.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileia.recyclerview.holder.BaseViewHolder;

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
            BaseViewHolder holder = (BaseViewHolder)mViewHolder.getConstructor(View.class).newInstance(view);
            // Configuramos el adapter
            holder.setAdapter(this);
            // Devolvemos holder
            return holder;
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
    public void addAll(ArrayList list){
        mValues.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * Obtener array de los items
     * @return
     */
    public ArrayList<Object> getValues() {
        return mValues;
    }
}
