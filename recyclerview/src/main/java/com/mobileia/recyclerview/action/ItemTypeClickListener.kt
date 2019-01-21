package com.mobileia.recyclerview.action

import android.view.View

interface ItemTypeClickListener<T> {
    fun onItemClick(view: View, item: T)
}