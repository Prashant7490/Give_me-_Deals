package com.example.give_me_deals.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.give_me_deals.Data.LatestDealModel
import com.example.give_me_deals.R

class LatestDeals (private val mList: ArrayList<LatestDealModel>, val context: Context) : RecyclerView.Adapter<LatestDeals.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestDeals.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rowlatestdeal,parent, false)

        return LatestDeals.ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dataItem = mList[position]

        Glide.with(holder.featureImage).load(dataItem.image1).into(holder.featureImage)
        holder.title.text=dataItem.title
        holder.tvDiscount.text=dataItem.discount
        holder.tvPrice.text=dataItem.price

    }
    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val featureImage: ImageView = itemView.findViewById(R.id.imview)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDiscount: TextView = itemView.findViewById(R.id.tvDiscount)
        val tvPrice: TextView = itemView.findViewById(R.id.tvprice)
    }
}