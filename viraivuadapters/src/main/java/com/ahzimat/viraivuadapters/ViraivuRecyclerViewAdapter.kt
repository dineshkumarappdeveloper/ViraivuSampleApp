package com.ahzimat.viraivuadapters


import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


class ViraivuRecyclerAdapter<T>(
    private val viewHolderFactory: ((parent: ViewGroup) -> ViraivuViewHolder<T>)
): RecyclerView.Adapter<ViraivuViewHolder<T>>() {

    private var viraivuAdapterCallBackListener: ViraivuAdapterCallBackListener? = null

    private lateinit var viewGroup: ViewGroup


    var items: List<T>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViraivuViewHolder<T> {
        this.viewGroup = parent
        return viewHolderFactory(parent)
    }

    override fun onBindViewHolder(holder: ViraivuViewHolder<T>, position: Int) {
        val item = items?.get(position)
        viraivuAdapterCallBackListener?.onViraivuViewHolderDataViewGroup(holder.viewDataBinding,
            viewGroup,item,position)

        holder.itemView.setOnClickListener {
            if (item != null) {
                viraivuAdapterCallBackListener?.onViraivuItemClicked(item)
            }
        }
    }

    override fun getItemCount(): Int = items?.size ?: 0


    fun setOnViraivuAdapterCallbackListener(viraivuAdapterCallBackListener: ViraivuAdapterCallBackListener){
        this.viraivuAdapterCallBackListener = viraivuAdapterCallBackListener
    }

    interface ViraivuAdapterCallBackListener{
        fun onViraivuItemClicked(data:Any)
        fun onViraivuViewHolderDataViewGroup(viewDataBinding: ViewDataBinding, viewGroup:ViewGroup, data: Any?,position: Int)
    }


}


open class ViraivuViewHolder<T>(
    _bindingView:ViewDataBinding
) : RecyclerView.ViewHolder(_bindingView.root) {

    var viewDataBinding:ViewDataBinding = _bindingView

}