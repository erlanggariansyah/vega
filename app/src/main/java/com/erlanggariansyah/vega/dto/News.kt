package com.erlanggariansyah.vega.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String?,
    val subtitle: String?,
    val description: String?,
    val image: Int,
    val createdDate: String?
) : Parcelable