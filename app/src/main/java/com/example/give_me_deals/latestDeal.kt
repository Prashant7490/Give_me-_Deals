package com.example.give_me_deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.give_me_deals.Data.DealsNearMeModel
import com.example.give_me_deals.adapter.DealsNearMeAdapter
import com.example.give_me_deals.databinding.ActivityFeatureDealsBinding
import com.example.give_me_deals.databinding.ActivityLatestDealBinding

class latestDeal : AppCompatActivity() {
    lateinit var binding: ActivityLatestDealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLatestDealBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.Red)

        binding.TVLatestFilter.setOnClickListener {
            val intent = Intent(this, activityLastestDealFilters::class.java)
            startActivity(intent)
        }

            val dealsNearMeAdapterlist = ArrayList<DealsNearMeModel>()
            dealsNearMeAdapterlist.add(
                DealsNearMeModel("https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-15-pro-1.jpg",
                    "Mobile",
                    "50%",
                    "999$",
                    "E2Business"
                ))

            dealsNearMeAdapterlist.add(
                DealsNearMeModel("https://lh3.googleusercontent.com/spp/AOgFAqMdY87eYVzrMd-twQe9GUNWcZSzR8RHkfQ43du5ZZ3MQIIGL4iMhjfMtdvI1meWR7eGi0yD3VYD0fDtElA0LVNFeV7NN7oR3YWiKjfzGWlCtB_SRk1ynzQ1igsJY00gAHfj31iFyHWLwaHOnf5agys8mrsjbgQRQDb7nT5Npr3fQrMzXEJNj5kkNdcqBCxqlHH8Wdb-zb4=s512-rw-pd-pc0x00ffffff",
                    "BoultEarbudsZ40",
                    "50%",
                    "15.68$",
                    "E2Business"
                ))


            dealsNearMeAdapterlist.add(
                DealsNearMeModel("https://image-us.samsung.com/us/smartphones/galaxy-s23-ultra/images/gallery/phantomblack/01-DM3-PhantomBlack-PDP-1600x1200.jpg",
                            "SamsungS24",
                            "50%",
                            "750$",
                            "E2Business"
                        ))




            dealsNearMeAdapterlist.add(
                DealsNearMeModel("https://lh3.googleusercontent.com/spp/AOgFAqOpls68RKDjyGiUaJqW7UKdCrXTHb5C4deLP6cMquuJwEJmke4dQEvw4HnU96VIgm9r3FlKa0MCq17Ibds3a__DHmuBzXgdF19s6OY-7JqTlhxmzg5c32E-opo1620tU971-IHOse-tGnKKr0XUQ_LFloCv9VzFT9Yl548WIg1sFuNhZPmqJSdyULGLp0y_uI6Dsair5A=s512-rw-pd-pc0x00ffffff",
                    "AppleAirpods",
                    "50%",
                    "144.74$",
                    "E2Business"
                ))




            dealsNearMeAdapterlist.add(
                DealsNearMeModel("https://images.hindustantimes.com/tech/img/2023/10/31/960x540/llll_1698711300375_1698711305176.png",
                    "AppleMacBookM3Chip",
                    "50%",
                    "1927.69$",
                    "E2Business"
                ))



            dealsNearMeAdapterlist.add(
                DealsNearMeModel("https://lh3.googleusercontent.com/spp/AOgFAqMdWudlRntQmQVECo1Tes7dhtl1kgweqVBjqSRrgWv9xr2CZdrf2BvnChIyk761HIC46YbtH5LvKd496V5KvJBTO1Fa64e-X40BOrjY690Ph9fzplwaJcO4q4RAy2XjFqmtqUgKKmBOfJAiFS8YhZkahG5uM73Q0q2sfra22nnFaimPiGnRJb2lDByn9HVIXYxQApK-SA=s512-rw-pd-pc0x00ffffff",
                    "AppleWatchSe",
                    "50%",
                    "374.19$",
                    "E2Business"))

            val dealsNearMeAdapter= DealsNearMeAdapter(dealsNearMeAdapterlist,this)
            binding.rvFeatureDealsActivity.layoutManager = LinearLayoutManager(
                this
            )
            binding.rvFeatureDealsActivity.adapter=dealsNearMeAdapter


        }
    }