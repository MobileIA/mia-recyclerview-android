package com.mobileia.recyclerview.scroll;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by matiascamiletti on 25/10/17.
 */

abstract public class BaseScrollListener extends RecyclerView.OnScrollListener {

    /**
     * Varible que representa si se puede seguir cargando.
     */
    protected boolean mStopLoad = false;
    /**
     * True if we are still waiting for the last set of data to load.
     */
    protected boolean mLoading = true;
    /**
     * The total number of items in the dataset after the last load
     */
    protected int mPreviousTotal = 0;

    /**
     * Cancela para que no se cargue mas al llegar al final
     */
    public void stopLoad(){ mStopLoad = true;}

    /**
     * Inicia nuevamente la funcionalidad
     */
    public void startLoad(){ mStopLoad = false; }
}
