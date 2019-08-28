package com.example.engine210.vscorebaord

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Scores (
    var left_match: Int = 0,
    var left_score: Int = 0,
    var right_match: Int = 0,
    var right_score: Int = 0,
    var left_background: Int = R.drawable.score_blue,
    var right_background: Int = R.drawable.score_red
    ): Parcelable