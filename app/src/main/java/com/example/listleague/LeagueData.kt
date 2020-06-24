package com.example.listleague

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueData(val name: String?, val image: Int?, val desc: String?): Parcelable