package com.example.engine210.vscorebaord

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.board_buttons.*
import kotlinx.android.synthetic.main.center_board.*

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    private var volleyBallBoard = ScoreBoard()

    private fun setScore(scores: Scores) {
        imageView_left.setBackgroundResource(scores.left_background)
        imageView_right.setBackgroundResource(scores.right_background)
        textView_score_left.text = scores.left_score.toString()
        textView_score_right.text = scores.right_score.toString()
        textView_match_left.text = scores.left_match.toString()
        textView_match_right.text = scores.right_match.toString()
        return
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setScore(volleyBallBoard.record)

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

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_plus_left -> volleyBallBoard.leftTeamPlus()
            R.id.button_minus_left -> volleyBallBoard.leftTeamMinus()
            R.id.button_plus_right -> volleyBallBoard.rightTeamPlus()
            R.id.button_minus_right -> volleyBallBoard.rightTeamMinus()
            R.id.button_reset -> volleyBallBoard.reset()
            R.id.button_undo -> volleyBallBoard.undo()
            R.id.button_switch -> volleyBallBoard.switch()
        }
        setScore(volleyBallBoard.record)
    }

    override fun onLongClick(v: View): Boolean {
        when (v.id) {
            R.id.button_plus_left -> volleyBallBoard.leftTeamMatchPlus()
            R.id.button_minus_left -> volleyBallBoard.leftTeamMatchMinus()
            R.id.button_plus_right -> volleyBallBoard.rightTeamMatchPlus()
            R.id.button_minus_right -> volleyBallBoard.rightTeamMatchMinus()
        }
        setScore(volleyBallBoard.record)
        return true
    }
}
