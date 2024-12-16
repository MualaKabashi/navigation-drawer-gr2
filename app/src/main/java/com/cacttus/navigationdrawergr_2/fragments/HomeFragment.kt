package com.cacttus.navigationdrawergr_2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cacttus.navigationdrawergr_2.R
import com.cacttus.navigationdrawergr_2.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
//    private lateinit var binding : HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = HomeFragmentBinding.inflate(layoutInflater)
//        return binding.root
        return layoutInflater.inflate(R.layout.home_fragment, container, false)
    }
}