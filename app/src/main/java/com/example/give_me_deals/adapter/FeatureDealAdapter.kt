package com.example.give_me_deals.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.give_me_deals.Data.FeatureDealModel
import com.example.give_me_deals.DealsInformation
import com.example.give_me_deals.R

class FeatureDealAdapter (private val mList: ArrayList<FeatureDealModel>,val context: Context) : RecyclerView.Adapter<FeatureDealAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_featured_deal,parent, false)

        return ViewHolder(view)

    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dataItem = mList[position]

        Glide.with(holder.featureImage).load(dataItem.image1).into(holder.featureImage)
        holder.title.text=dataItem.title
        holder.tvDiscount.text=dataItem.discount
        holder.tvPrice.text=dataItem.price

        holder.itemView.setOnClickListener{
            val intent = Intent(context,DealsInformation::class.java)
            context.startActivity(intent)
        }

    }
    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val featureImage: ImageView = itemView.findViewById(R.id.imview)
        val title: TextView = itemView.findViewById(R.id.tvjeans)
        val tvDiscount: TextView = itemView.findViewById(R.id.tvDiscount)
        val tvPrice: TextView = itemView.findViewById(R.id.tvprice)
    }
}