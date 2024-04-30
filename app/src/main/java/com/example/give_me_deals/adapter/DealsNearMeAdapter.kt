package com.example.give_me_deals.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.give_me_deals.Data.DealsNearMeModel
import com.example.give_me_deals.R

class DealsNearMeAdapter (private val mList: ArrayList<DealsNearMeModel>,val context: Context) : RecyclerView.Adapter<DealsNearMeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsNearMeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deals_near_me,parent, false)

        return DealsNearMeAdapter.ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dataItem = mList[position]

        Glide.with(holder.featureImage).load(dataItem.image1).into(holder.featureImage)
        holder.title.text=dataItem.title
        holder.discount.text=dataItem.discount
        holder.businessName.text=dataItem.business
        holder.price.text=dataItem.price


    }
    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val featureImage: ImageView = itemView.findViewById(R.id.imview)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val discount: TextView = itemView.findViewById(R.id.tvDiscount)
        val businessName: TextView = itemView.findViewById(R.id.tvBusinessName)
        val price: TextView = itemView.findViewById(R.id.tvPrice)

    }
}