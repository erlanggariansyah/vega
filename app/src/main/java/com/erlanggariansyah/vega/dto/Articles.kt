package com.erlanggariansyah.vega.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Articles(
    val title: String?,
    val createdDate: String?,
    val file: Int
): Parcelable
