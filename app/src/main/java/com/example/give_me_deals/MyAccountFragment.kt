package com.example.give_me_deals

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.give_me_deals.databinding.ActivityLoginBinding
import com.example.give_me_deals.databinding.FragmentMyAccountBinding

class MyAccountFragment : Fragment() {
    lateinit var myAccountBinding: FragmentMyAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myAccountBinding = FragmentMyAccountBinding.inflate(layoutInflater)

        myAccountBinding.tvTitle3.setOnClickListener {
            val intent = Intent(requireContext(), sign_up::class.java)
            requireActivity().startActivity(intent)
        }
        myAccountBinding.BtnUnlock.setOnClickListener {
            val intent = Intent(requireContext(), Login::class.java)
            requireActivity().startActivity(intent)
        }
        return myAccountBinding.root
    }

}