package com.example.engine210.vscorebaord

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    @Parcelize
    data class Scores(
            var left_match: Int = 0,
            var right_match: Int = 0,
            var left_score: Int = 7,
            var right_score: Int = 0
    ): Parcelable

    fun Switch(scores: Scores) {
        scores.left_score = scores.right_score.also { scores.right_score = scores.left_score }
        scores.left_match = scores.right_match.also { scores.right_match = scores.left_match }
        return
    }

    var scores = Scores()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView_score_left.text = "7"
        button_minus_left.setOnClickListener(this)
        button_minus_right.setOnClickListener(this)
        button_plus_left.setOnClickListener(this)
        button_plus_right.setOnClickListener(this)
        button_reset.setOnClickListener(this)
        button_undo.setOnClickListener(this)
        button_switch.setOnClickListener(this)
    }
    /// TODO　implement buttons function
    override fun onClick(v: View){
        when(v.id){
            R.id.button_minus_left ->
                Toast.makeText(this, "btn min left", Toast.LENGTH_SHORT).show()
            R.id.button_minus_right ->
                Toast.makeText(this, "btn min right", Toast.LENGTH_SHORT).show()
            R.id.button_plus_left ->
                Toast.makeText(this, "btn plus left", Toast.LENGTH_SHORT).show()
            R.id.button_plus_right ->
                Toast.makeText(this, "btn plus right", Toast.LENGTH_SHORT).show()
            R.id.button_reset ->
                Toast.makeText(this, "reset", Toast.LENGTH_SHORT).show()
            R.id.button_undo ->
                Toast.makeText(this, "undo", Toast.LENGTH_SHORT).show()
            R.id.button_switch -> {
                Switch(scores)
                Toast.makeText(this, "switch", Toast.LENGTH_SHORT).show()
            }
        }
        textView_score_left.text = scores.left_score.toString()
        textView_score_right.text = scores.right_score.toString()
        textView_match_left.text = scores.left_match.toString()
        textView_match_right.text = scores.right_match.toString()
    }
}
