package com.example.stevdzasan_navigationcomponent.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.stevdzasan_navigationcomponent.R


class SecondScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second_screen, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        val tvNext = view.findViewById<TextView>(R.id.next)
        tvNext.setOnClickListener {
            viewPager?.currentItem = 2
        }
        return view
    }

}