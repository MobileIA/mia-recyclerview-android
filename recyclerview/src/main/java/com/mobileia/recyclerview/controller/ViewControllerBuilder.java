package com.mobileia.recyclerview.controller;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by matiascamiletti on 9/2/18.
 */

public class ViewControllerBuilder {

    /**
     * Almacena el contenedor de la vista
     */
    protected ViewGroup mViewGroup;
    /**
     * Almacena el layout de la vista
     */
    protected int mLayoutView;
    /**
     * Almacena la clase del ViewHolder del listado
     */
    protected Class<?> mViewController;

    /**
     * Configura el contenedor donde se va a mostrar la vista
     * @param container
     * @return
     */
    public ViewControllerBuilder withContainer(ViewGroup container){
        mViewGroup = container;
        return this;
    }

    /**
     * COnfigura el layout que se va a inflar para la vista
     * @param layoutRes
     * @return
     */
    public ViewControllerBuilder withLayout(@LayoutRes int layoutRes){
        mLayoutView = layoutRes;
        return this;
    }

    /**
     * configura la clase de ViewController
     * @param baseView
     * @return
     */
    public ViewControllerBuilder withViewController(Class<?> baseView){
        mViewController = baseView;
        return this;
    }

    /**
     * Funcion que ejecuta el view controller
     * @return
     */
    public BaseViewController build(){
        // Inflamos el layout
        View view = LayoutInflater.from(mViewGroup.getContext()).inflate(mLayoutView, mViewGroup, false);
        // Generamos el viewHolder
        try {
            BaseViewController baseController = (BaseViewController) mViewController.getConstructor(View.class).newInstance(view);
            // Agregamos vista al contenedor
            mViewGroup.addView(baseController.getView());
            // Devolvemos controlador
            return baseController;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
