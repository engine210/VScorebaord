package com.example.engine210.vscorebaord

import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @Parcelize
    data class Scores(
        var blue_set: Int = 0,
        var red_set: Int = 0,
        var blue_score: Int = 0,
        var red_score: Int = 0
    ): Parcelable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
