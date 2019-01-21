package com.mobileia.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobileia.recyclerview.holder.BaseViewHolder

class MultiBuilderAdapter: RecyclerView.Adapter<BaseViewHolder<Any>>() {

    private val linkManager: AdapterLinkManager by lazy { AdapterLinkManager() }
    val list: MutableList<Any> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        val viewHolderClass = linkManager.createViewHolder(viewType)
        val con = viewHolderClass.getConstructor(View::class.java)
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        var moreViewHolder: BaseViewHolder<Any>? = null
        try {
            moreViewHolder = con.newInstance(view) as BaseViewHolder<Any>
        } catch (e: Exception) {
            e.printStackTrace()
            if (moreViewHolder == null) {
                throw java.lang.Exception(viewHolderClass.simpleName)
                //throw ViewHolderInitErrorException(viewHolderClass.simpleName, e.cause?.message?: "")
            }
        }
        //injectValueInHolder(viewType, viewHolderClass, moreViewHolder!!)
        return moreViewHolder!!

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseViewHolder<Any>, position: Int) {
        val item = list[position]
        holder.setOnItemTypeClickListener(linkManager.bindClickListener(holder))
        holder.setObject(item)
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        val any = list[position]
        return linkManager.attachViewTypeLayout(any)
    }

    /** [register] register viewType which single link with model  */
    fun register(registerItem: ItemTypeHolder) = linkManager.register(registerItem)

    /**
     * Funcion para agregar un objeto al listado
     * @param object
     */
    fun add(item: Any) {
        list.add(item)
        notifyDataSetChanged()
    }

    /**
     * Funcion para agregar un objeto al listado
     * @param index
     * @param object
     */
    fun add(index: Int, item: Any) {
        list.add(index, item)
        notifyDataSetChanged()
    }

    /**
     * Funcino para agregar un listado de objetos
     * @param list
     */
    fun addAll(items: List<*>) {
        list.addAll(items as Collection<Any>)
        //list.addAll(list as Collection<Any>)
        notifyDataSetChanged()
    }

    fun addData(data: Any){
        if (data is List<*>) {
            list.addAll(data as Collection<Any>)
        } else {
            list.add(data)
        }
    }
}