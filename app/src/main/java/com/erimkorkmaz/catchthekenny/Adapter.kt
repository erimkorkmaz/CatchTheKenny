package com.erimkorkmaz.catchthekenny

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val randomIndex: Int) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_kenny,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = 9

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           holder.bind(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            if (position == randomIndex) {
                itemView.visibility = View.VISIBLE
            }else{
                itemView.visibility = View.GONE
            }
        }
    }

}