package com.mobileia.recyclerview.adapter

import androidx.collection.SparseArrayCompat
import com.mobileia.recyclerview.action.ItemTypeClickListener
import com.mobileia.recyclerview.holder.BaseViewHolder
import java.lang.reflect.ParameterizedType

class AdapterLinkManager {

    /** [viewHolderMap] save MoreViewHolder by layout id */
    private var viewHolderMap = SparseArrayCompat<Class<out BaseViewHolder<*>>>()

    /** [modelTypeMap] save Data::class by layout id */
    private var modelTypeMap = SparseArrayCompat<Class<*>>()

    /** [modelTypeMap] save clickListener by layout id */
    private var clickListenerMap = SparseArrayCompat<ItemTypeClickListener<*>?>()

    private var injectValueMap = SparseArrayCompat<Map<String, Any>>()

    /**
     *  [register] register single MoreViewType , MoreViewType can't repeat
     *  if two ViewType's getViewModel() return same Data::class
     *  [viewHolderMap] and [modelTypeMap] will remove oldViewType and replace by newViewType
     */
    fun register(registerItem: ItemTypeHolder) {
        val model = reflectClass(registerItem.clazzViewHolder)
        if (modelTypeMap.indexOfValue(model) != -1) {
            val index = modelTypeMap.indexOfValue(model)
            //val key = viewHolderMap.keyAt(index)
            //val oldViewType = viewHolderMap[key]
            //val modelName = model.simpleName
            //val newTypeName = registerItem.clazzViewHolder.simpleName
            //val oldViewTypeName = oldViewType?.simpleName
            viewHolderMap.removeAt(index)
            modelTypeMap.removeAt(index)
            clickListenerMap.removeAt(index)
        }
        @Suppress("UNCHECKED_CAST")
        viewHolderMap.put(registerItem.layoutId, registerItem.clazzViewHolder)
        modelTypeMap.put(registerItem.layoutId, model)
        clickListenerMap.put(registerItem.layoutId, registerItem.clickListener)
    }

    /** [createViewHolder] return MoreViewHolder in onCreateViewHolder() to create viewHolder*/
    fun createViewHolder(type: Int): Class<out BaseViewHolder<*>> {
        if (type == -1) {
            throw  NullPointerException("no such type!")
        }

        val viewHolder = viewHolderMap[type]
        //val multiViewHolder = multiViewHolderMap[type]

        if (viewHolder != null) {
            return viewHolder
        }

        /*if (multiViewHolder != null) {
            return multiViewHolder
        }*/

        throw  NullPointerException("no such type!")
    }

    /**
     * [attachViewTypeLayout] attach to viewType' layout by data item
     * if data belong to single register will return viewType's unique key (layout)
     * if data belong to multi register will return -1
     * if data not register will throw [ModelNotRegisterException]
     */
    fun attachViewTypeLayout(any: Any): Int {
        val clazz = any.javaClass
        val type = modelTypeMap.indexOfValue(clazz)
        /*if (type == -1) {
            val multiClazz = multiModelMap.containsKey(clazz)
            if (multiClazz) {
                val multiLink = multiModelMap[clazz]
                multiLink?.let {
                    val link = it.link(any)
                    if (multiViewHolderMap.get(link.layoutId) == null) {
                        multiViewHolderMap.put(link.layoutId, link.clazzViewHolder)
                        clickListenerMap.put(link.layoutId, link.clickListener)
                    }
                    return link.layoutId
                }
            } else {
                throw ModelNotRegisterException(clazz.simpleName as String)
            }
        }*/
        return viewHolderMap.keyAt(type)
    }

    fun bindClickListener(holder: BaseViewHolder<*>): ItemTypeClickListener<*>? {
        val clazz = holder.javaClass

        val viewIndex = viewHolderMap.indexOfValue(clazz)
        //val multiIndex = multiViewHolderMap.indexOfValue(clazz)

        if (viewIndex != -1) {
            val viewLayout = viewHolderMap.keyAt(viewIndex)
            return clickListenerMap[viewLayout]
        }

        /*if (multiIndex != -1) {
            val multiLayout = multiViewHolderMap.keyAt(multiIndex)
            return clickListenerMap[multiLayout]
        }*/

        return null
    }

    /*override fun injectValueInHolder(type: Int, clazz: Class<out BaseViewHolder<*>>, moreViewHolder: BaseViewHolder<Any>) {
        val valueMap = injectValueMap[type] ?: return
        if (valueMap.isEmpty()) return
        valueMap.forEach { entry ->
            val key = entry.key
            val value = entry.value
            clazz.declaredFields.forEach field@{ field ->
                val annotation = field.getAnnotation(MoreInject::class.java)
                annotation?.also {
                    if (key == it.key) {
                        field.isAccessible = true
                        field.set(moreViewHolder, value)
                        field.isAccessible = false
                        return@field
                    }
                }
            }
        }
    }*/

    @Suppress("UNCHECKED_CAST")
    private fun reflectClass(clazz: Class<*>): Class<Any> {
        val type = clazz.genericSuperclass as ParameterizedType
        val p = type.actualTypeArguments
        return p[0] as Class<Any>
    }
}