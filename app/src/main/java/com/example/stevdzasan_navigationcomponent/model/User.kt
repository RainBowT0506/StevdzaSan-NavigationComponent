package com.example.stevdzasan_navigationcomponent.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
 data class User(
    val firstName: String,
    val lastName: String
) : Parcelable
