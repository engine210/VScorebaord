package com.example.engine210.vscorebaord

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.center_board.*

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    @Parcelize
    data class Scores(
            var left_match: Int = 0,
            var left_score: Int = 0,
            var right_match: Int = 0,
            var right_score: Int = 0,
            var left_background: Int = R.drawable.score_blue,
            var right_background: Int = R.drawable.score_red
    ) : Parcelable

    fun Switch(scores: Scores) {
        scores.left_score = scores.right_score.also { scores.right_score = scores.left_score }
        scores.left_match = scores.right_match.also { scores.right_match = scores.left_match }
        scores.left_background = scores.right_background.also { scores.right_background = scores.left_background }
        return
    }

    fun setScore(scores: Scores) {
        imageView_left.setBackgroundResource(scores.left_background)
        imageView_right.setBackgroundResource(scores.right_background)
        textView_score_left.text = scores.left_score.toString()
        textView_score_right.text = scores.right_score.toString()
        textView_match_left.text = scores.left_match.toString()
        textView_match_right.text = scores.right_match.toString()
        return
    }

    private var scores = Scores()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setScore(scores)
        button_minus_left.setOnClickListener(this)
        button_minus_right.setOnClickListener(this)
        button_plus_left.setOnClickListener(this)
        button_plus_right.setOnClickListener(this)
        button_reset.setOnClickListener(this)
        button_undo.setOnClickListener(this)
        button_switch.setOnClickListener(this)

        button_minus_left.setOnLongClickListener(this)
        button_minus_right.setOnLongClickListener(this)
        button_plus_left.setOnLongClickListener(this)
        button_plus_right.setOnLongClickListener(this)
    }

    /// TODO　implement undo btn
    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_minus_left -> {
                if (scores.left_score > 0) {
                    scores.left_score--
                } else if (scores.left_score == 0 && scores.left_match > 0) {
                    scores.left_match--
                    scores.left_score = 24
                }
            }
            R.id.button_minus_right -> {
                if (scores.right_score > 0) {
                    scores.right_score--
                } else if (scores.right_score == 0 && scores.right_match > 0) {
                    scores.right_match--
                    scores.right_score = 24
                }
            }
            R.id.button_plus_left -> {
                if (scores.left_score < 24) {
                    scores.left_score++
                } else {
                    scores.left_score = 0
                    scores.left_match++
                }
            }
            R.id.button_plus_right -> {
                if (scores.right_score < 24) {
                    scores.right_score++
                } else {
                    scores.right_score = 0
                    scores.right_match++
                }
            }
            R.id.button_reset -> {
                scores.left_score = 0
                scores.right_score = 0
                scores.left_match = 0
                scores.right_match = 0
            }
            R.id.button_undo ->
                Toast.makeText(this, "undo", Toast.LENGTH_SHORT).show()
            R.id.button_switch -> {
                Switch(scores)
            }
        }
        setScore(scores)
    }

    override fun onLongClick(v: View): Boolean {
        when (v.id) {
            R.id.button_minus_left -> {
                if (scores.left_match > 0) {
                    scores.left_match--
                }
            }
            R.id.button_minus_right -> {
                if (scores.right_match > 0) {
                    scores.right_match--
                }
            }
            R.id.button_plus_left -> {
                scores.left_match++
            }
            R.id.button_plus_right -> {
                scores.right_match++
            }
        }
        setScore(scores)
        return true
    }
}
