package com.example.give_me_deals

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.give_me_deals.Data.DealsNearMeModel
import com.example.give_me_deals.Data.FeatureDealModel
import com.example.give_me_deals.Data.LatestDealModel
import com.example.give_me_deals.Data.PopularBusinessModel
import com.example.give_me_deals.adapter.DealsNearMeAdapter
import com.example.give_me_deals.adapter.FeatureDealAdapter
import com.example.give_me_deals.adapter.LatestDeals
import com.example.give_me_deals.adapter.PopularBusinessAdapter
import com.example.give_me_deals.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(inflater, container, false);

        binding.tvViewAllDeals.setOnClickListener {
            (requireActivity() as HomeActivity).setBottomNav(R.id.nearby)

        }

        binding.tvView.setOnClickListener {
            val intent = Intent(requireContext(), FeatureDealsActivity::class.java)
            startActivity(intent)

        }
        binding.tvViewAll.setOnClickListener {
            (requireActivity() as HomeActivity).setBottomNav(R.id.business)

        }

        binding.tvViewDeal.setOnClickListener {
            val intent = Intent(requireContext(), latestDeal::class.java)
            startActivity(intent)

        }

        //Feature Deal
        val list = ArrayList<FeatureDealModel>()
        list.add(FeatureDealModel("https://img01.ztat.net/article/spp-media-p1/46c80dc4e3d74beeb0b4bd35699ee506/fece4a8c79da49d1b5972c7fdab6e07d.jpg?imwidth=762&filter=packshot",
            "Jeans",
            "50%",
            "100$",
        "E2Cloths"))

        list.add(FeatureDealModel("https://evilato.com/wp-content/uploads/2021/07/IMG-20210707-WA0073.jpg",
            "Shirt",
            "50%",
            "100$",
        "E2Cloths"))
        list.add(FeatureDealModel("data:image/jpeg;base64,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",
            "Shorts",
            "50%",
            "100$",
        "E2Cloths"))

        val adapter=FeatureDealAdapter(list,requireContext())
        binding.rvFeatureDeal.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvFeatureDeal.adapter=adapter


        //Latest Deal
        val latestdeallist = ArrayList<LatestDealModel>()
        latestdeallist.add(
            LatestDealModel("https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-15-pro-1.jpg",
                "Mobile",
                "50%",
                "999$"))

        latestdeallist.add(
            LatestDealModel("https://lh3.googleusercontent.com/spp/AOgFAqMdY87eYVzrMd-twQe9GUNWcZSzR8RHkfQ43du5ZZ3MQIIGL4iMhjfMtdvI1meWR7eGi0yD3VYD0fDtElA0LVNFeV7NN7oR3YWiKjfzGWlCtB_SRk1ynzQ1igsJY00gAHfj31iFyHWLwaHOnf5agys8mrsjbgQRQDb7nT5Npr3fQrMzXEJNj5kkNdcqBCxqlHH8Wdb-zb4=s512-rw-pd-pc0x00ffffff",
                "BoultEarbudsZ40",
                "50%",
                "15.68$"))
        latestdeallist.add(
            LatestDealModel("https://image-us.samsung.com/us/smartphones/galaxy-s23-ultra/images/gallery/phantomblack/01-DM3-PhantomBlack-PDP-1600x1200.jpg",
                "SamsungS24",
                "50%",
                "750$"))
        latestdeallist.add(
            LatestDealModel("https://lh3.googleusercontent.com/spp/AOgFAqOpls68RKDjyGiUaJqW7UKdCrXTHb5C4deLP6cMquuJwEJmke4dQEvw4HnU96VIgm9r3FlKa0MCq17Ibds3a__DHmuBzXgdF19s6OY-7JqTlhxmzg5c32E-opo1620tU971-IHOse-tGnKKr0XUQ_LFloCv9VzFT9Yl548WIg1sFuNhZPmqJSdyULGLp0y_uI6Dsair5A=s512-rw-pd-pc0x00ffffff",
                "AppleAirpods",
                "50%",
                "144.74$"))
        latestdeallist.add(
            LatestDealModel("https://images.hindustantimes.com/tech/img/2023/10/31/960x540/llll_1698711300375_1698711305176.png",
                "AppleMacBookM3Chip",
                "50%",
                "1927.69$"))
        latestdeallist.add(
            LatestDealModel("https://lh3.googleusercontent.com/spp/AOgFAqMdWudlRntQmQVECo1Tes7dhtl1kgweqVBjqSRrgWv9xr2CZdrf2BvnChIyk761HIC46YbtH5LvKd496V5KvJBTO1Fa64e-X40BOrjY690Ph9fzplwaJcO4q4RAy2XjFqmtqUgKKmBOfJAiFS8YhZkahG5uM73Q0q2sfra22nnFaimPiGnRJb2lDByn9HVIXYxQApK-SA=s512-rw-pd-pc0x00ffffff",
                "AppleWatchSe",
                "50%",
                "374.19$"))

        val latestDealAdapter=LatestDeals(latestdeallist,requireContext())
        binding.rvLatestDeal.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvLatestDeal.adapter=latestDealAdapter

        //next
        val popularBusinessAdapterlist = ArrayList<PopularBusinessModel>()
        popularBusinessAdapterlist.add(
            PopularBusinessModel("https://i.pinimg.com/originals/1c/07/08/1c0708a88937e5970cf48c40e7db6a7f.jpg",
                "E2Business",
                "ABC Cloth",
                "Kings Beach"))

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




        val popularBusinessAdapter=PopularBusinessAdapter(popularBusinessAdapterlist,requireContext())
        binding.rvPopularBusiness.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvPopularBusiness.adapter=popularBusinessAdapter



        val dealsNearMeAdapterlist = ArrayList<DealsNearMeModel>()
        dealsNearMeAdapterlist.add(
            DealsNearMeModel(
                "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-15-pro-finish-select-202309-6-7inch-bluetitanium_AV1_GEO_EMEA?wid=5120&hei=2880&fmt=p-jpg&qlt=80&.v=1692845694831",
                "Iphone",
                "100$",
                "25%",
                "E2Business",

            ))
        dealsNearMeAdapterlist.add(
            DealsNearMeModel(
                "https://rukminim2.flixcart.com/image/416/416/k6ci8i80/headphone/8/y/n/it-world-i-12-original-imafzbhwntwftbkq.jpeg?q=70&crop=false",
                "Apple AirPords",
                "50$",
                "10$",
                "E2Business",
            ))
        dealsNearMeAdapterlist.add(
            DealsNearMeModel(
                "https://images.samsung.com/is/image/samsung/p6pim/in/2401/gallery/in-galaxy-s24-s928-sm-s928bztqins-thumb-539573348?$240_240_PNG$",
                "Samsung S24",
                "100$",
                "20$",
                "E2Business"
            ))

        dealsNearMeAdapterlist.add(
            DealsNearMeModel(
                "https://images.hindustantimes.com/tech/img/2023/10/31/960x540/llll_1698711300375_1698711305176.png",
                "AppleMacBookM3Chip",
                "50$",
                "15$",
                "E2Business"
            ))

        dealsNearMeAdapterlist.add(
            DealsNearMeModel(
                "https://lh3.googleusercontent.com/spp/AOgFAqPWMEsFnvHKXSVW0pn3Ho2ydTOwgT45_xdpGTBULwTzIa1yKvwF00Ld5nRzDrj4Hf7H66vAFQpeJiQVIzLcjfW2cQBBqob828ozw0AzBgVPG6xftyCyd156wqX6DJkgkPvh7Aci-dDRiTOgoFBCQYDJd2iObzgjD1kI09T4NN48ROr9lMFMXx_vBLfedTmTnToLG5vECws=s512-rw-pd-pc0x00ffffff",
                "Bolult EarbudsZ40",
                "60$",
                "10$",
                "E2Business"
            ))

        dealsNearMeAdapterlist.add(
            DealsNearMeModel(
                "https://lh3.googleusercontent.com/spp/AOgFAqMdWudlRntQmQVECo1Tes7dhtl1kgweqVBjqSRrgWv9xr2CZdrf2BvnChIyk761HIC46YbtH5LvKd496V5KvJBTO1Fa64e-X40BOrjY690Ph9fzplwaJcO4q4RAy2XjFqmtqUgKKmBOfJAiFS8YhZkahG5uM73Q0q2sfra22nnFaimPiGnRJb2lDByn9HVIXYxQApK-SA=s512-rw-pd-pc0x00ffffff",
                "AppleWatchSe",
                "25$",
                "15$",
                "E2Business"
            ))



        val dealsNearMeAdapter=DealsNearMeAdapter(dealsNearMeAdapterlist,requireContext())
        binding.rvDealsNear.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.rvDealsNear.adapter=dealsNearMeAdapter

        return binding.root

    }
}