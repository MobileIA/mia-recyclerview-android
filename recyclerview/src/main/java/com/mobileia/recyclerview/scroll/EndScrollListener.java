package com.mobileia.recyclerview.scroll;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by matiascamiletti on 21/10/17.
 */

abstract public class EndScrollListener extends BaseScrollListener {

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
}
