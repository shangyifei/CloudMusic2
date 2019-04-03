package com.syf.ghost.cloudmusic.base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by Android on 2019/4/3.
 * auth Shangyifei
 */
abstract class BaseSingleRvAdapter<D,T : BaseViewHolder<D>?>(list: MutableList<D>) : RecyclerView.Adapter<T>(){
    private val data : MutableList<D> = list
   abstract override fun onCreateViewHolder(p0: ViewGroup, p1: Int): T

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: T, p1: Int) {
            p0?.bindView(data[p1])
    }

    fun setData(list: MutableList<D>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun addData(list: MutableList<D>){
        data.addAll(list)
        notifyDataSetChanged()
    }
}