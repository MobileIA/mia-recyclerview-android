package com.mobileia.recyclerview.adapter

import com.mobileia.recyclerview.action.ItemTypeClickListener
import com.mobileia.recyclerview.holder.BaseViewHolder

class ItemTypeHolder (val layoutId: Int,
                      val clazzViewHolder: Class<out BaseViewHolder<*>>,
                      var clickListener: ItemTypeClickListener<*>? = null)