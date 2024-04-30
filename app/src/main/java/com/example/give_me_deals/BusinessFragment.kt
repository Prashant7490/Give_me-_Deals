package com.example.give_me_deals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.give_me_deals.Data.DealsNearMeModel
import com.example.give_me_deals.Data.FeatureDealModel
import com.example.give_me_deals.Data.PopularBusinessModel
import com.example.give_me_deals.adapter.DealsNearMeAdapter
import com.example.give_me_deals.adapter.FeatureDealAdapter
import com.example.give_me_deals.adapter.PopularBusinessAdapter
import com.example.give_me_deals.databinding.FragmentBusinessBinding
import com.example.give_me_deals.databinding.FragmentHomeBinding
import com.example.give_me_deals.databinding.FragmentNearbyBinding

class   BusinessFragment : Fragment() {

    lateinit var binding: FragmentBusinessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBusinessBinding.inflate(inflater, container, false);

        val popularBusinessAdapterlist = ArrayList<PopularBusinessModel>()
        popularBusinessAdapterlist.add(
            PopularBusinessModel("https://i.pinimg.com/originals/1c/07/08/1c0708a88937e5970cf48c40e7db6a7f.jpg",
                "E2Business",
                "ABC Cloth",
                "Kings Beach")
        )

        popularBusinessAdapterlist.add(
            PopularBusinessModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQy1dJTc2cn1WM5iHXAM9wHM9C00x764IlIvWTDb_a5OQ&s",
                "SportsEquipments",
                "E2Sports",
                "Kings Beach"))

        popularBusinessAdapterlist.add(
            PopularBusinessModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fin.pinterest.com%2Fpin%2Fphone-shop-logo--500532946079206630%2F&psig=AOvVaw265g8sV39ZyxCw8H_mHG7q&ust=1712388121061000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNjFupDFqoUDFQAAAAAdAAAAABAT",
                "PhoneShop",
                "E2Mobiles",
                "Kings Beach"))

        popularBusinessAdapterlist.add(
            PopularBusinessModel("https://t4.ftcdn.net/jpg/04/16/93/07/360_F_416930724_1GVVgOYAEmU8RPcmLDSe8zsvFr9PHgH8.jpg",
                "Laptop",
                "E2Laptops",
                "Kings Beach"))



        val popularBusinessAdapter= PopularBusinessAdapter(popularBusinessAdapterlist,requireContext())
        binding.rvPopularBusiness.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvPopularBusiness.adapter=popularBusinessAdapter


        return binding.root


    }
}

