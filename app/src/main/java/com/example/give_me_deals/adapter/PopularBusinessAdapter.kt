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
import com.example.give_me_deals.Data.PopularBusinessModel
import com.example.give_me_deals.R

class PopularBusinessAdapter (private val mList: ArrayList<PopularBusinessModel>,val context: Context) : RecyclerView.Adapter<PopularBusinessAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularBusinessAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_business,parent, false)

        return PopularBusinessAdapter.ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dataItem = mList[position]

        Glide.with(holder.featureImage).load(dataItem.image1).into(holder.featureImage)
        holder.title.text=dataItem.title
        holder.tvlocation.text=dataItem.location
        holder.tvname.text=dataItem.businessName

    }
    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val featureImage: ImageView = itemView.findViewById(R.id.imview)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val tvlocation: TextView = itemView.findViewById(R.id.tvlocation)
        val tvname: TextView = itemView.findViewById(R.id.tvname)
    }
}