package com.mobileia.recyclerview.scroll;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by matiascamiletti on 21/10/17.
 */

abstract public class EndScrollListener extends RecyclerView.OnScrollListener {

    /**
     * Varible que representa si se puede seguir cargando.
     */
    protected boolean mStopLoad = false;
    /**
     * The total number of items in the dataset after the last load
     */
    protected int mPreviousTotal = 0;
    /**
     * True if we are still waiting for the last set of data to load.
     */
    protected boolean mLoading = true;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = recyclerView.getLayoutManager().getItemCount();
        int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

        if (mLoading && totalItemCount > mPreviousTotal) {
            mLoading = false;
            mPreviousTotal = totalItemCount;
        }
        int visibleThreshold = 5;
        if (!mLoading && !mStopLoad && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            // End has been reached
            onScrolledToEnd();
            // Seteamos que se esta cargando
            mLoading = true;
        }
    }

    abstract public void onScrolledToEnd();

    /**
     * Cancela para que no se cargue mas al llegar al final
     */
    public void stopLoad(){ mStopLoad = true;}

    /**
     * Inicia nuevamente la funcionalidad
     */
    public void startLoad(){ mStopLoad = false; }
}
