package com.dm.sample.navigation.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Notification(val id: String, val from: String, val message: String, val date: Date) :
    Parcelable