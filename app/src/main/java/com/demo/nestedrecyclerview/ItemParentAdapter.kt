package com.demo.nestedrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_banner.view.*
import kotlinx.android.synthetic.main.view_item_parent_recycler.view.*

class HomeItemParentAdapter(private val parents: List<ItemParentModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> return BannerViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_banner, parent, false))
            else -> return ItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_item_parent_recycler, parent, false))
        }

    }

    override fun getItemCount(): Int {
        return parents.size+1
    }

    override fun getItemViewType(position: Int): Int {
        return if (0 == position) {
            TYPE_BANNER
        } else {
            TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,
                                  position: Int) {
        when(holder)
        {
            is BannerViewHolder -> {
                holder.textView.text = "hello"
            }
            is ItemViewHolder -> {
                holder.textView.text =  parents[position-1].title

                holder.recyclerView.apply {
                    adapter = ChildAdapter(parents[position-1].children)
                    setRecycledViewPool(viewPool)
                }
            }
        }
    }


    private inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.tv_banner
    }

    private inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.tv_title
        val recyclerView : RecyclerView = itemView.rv_child
    }

    companion object {
        private val TYPE_BANNER = 0
        private val TYPE_ITEM = 1
    }
}