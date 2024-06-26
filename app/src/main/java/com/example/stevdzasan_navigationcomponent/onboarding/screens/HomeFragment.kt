package com.example.stevdzasan_navigationcomponent.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.stevdzasan_navigationcomponent.R

class HomeFragment : Fragment() {

    private val args by navArgs<HomeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        args.currentUser?.let {
            val tvFirstName = view.findViewById<TextView>(R.id.tvFirstName)
            val tvLastName = view.findViewById<TextView>(R.id.tvLastName)

            tvFirstName.text = it.firstName
            tvLastName.text = it.lastName
        }



        return view
    }

}