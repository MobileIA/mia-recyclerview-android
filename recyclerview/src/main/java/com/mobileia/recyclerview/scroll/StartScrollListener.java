package com.mobileia.recyclerview.scroll;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by matiascamiletti on 25/10/17.
 */

abstract public class StartScrollListener extends BaseScrollListener {

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = recyclerView.getLayoutManager().getItemCount();
        int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        // Verificamos si ya se cargaron nuevos items, viendo si la cantidad aumento
        if (mLoading && totalItemCount > mPreviousTotal) {
            mLoading = false;
            mPreviousTotal = totalItemCount;
        }
        int visibleThreshold = 5;
        if (!mLoading && !mStopLoad && firstVisibleItem <= visibleThreshold) {
            // Start has been reached
            onScrolledToStart();
            // Seteamos que se esta cargando
            mLoading = true;
        }
    }

    abstract public void onScrolledToStart();
}
