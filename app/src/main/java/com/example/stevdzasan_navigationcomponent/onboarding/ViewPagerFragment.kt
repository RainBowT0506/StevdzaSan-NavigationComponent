package com.example.stevdzasan_navigationcomponent.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.stevdzasan_navigationcomponent.R
import com.example.stevdzasan_navigationcomponent.onboarding.screens.FirstScreenFragment
import com.example.stevdzasan_navigationcomponent.onboarding.screens.SecondScreenFragment
import com.example.stevdzasan_navigationcomponent.onboarding.screens.ThirdScreenFragment

class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)

        val fragments = arrayListOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )

        val adapter = ViewPagerAdapter(
            fragments,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        viewPager.adapter = adapter

        return view
    }

}