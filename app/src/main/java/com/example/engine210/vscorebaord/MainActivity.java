package com.example.engine210.vscorebaord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //int scoreLeft, scoreRight, matchLeft, matchRight;
    int match_score = 25; // how many points in each match
    class Score {
        int scoreLeft = 0, scoreRight = 0, matchLeft = 0, matchRight = 0;
    }

    Score score;
    Score preScore; // to record the previous state of all score
    private Button BtnPlusLeft;
    private Button BtnMinusLeft;
    private Button BtnPlusRight;
    private Button BtnMinusRight;
    private Button BtnReset;
    private Button BtnUndo;
    private Button BtnSwitch;
    private TextView TxtScoreLeft;
    private TextView TxtScoreRight;
    private TextView TxtMatchLeft;
    private TextView TxtMatchRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnPlusLeft = findViewById(R.id.button_plus_left);
        BtnMinusLeft = findViewById(R.id.button_minus_left);
        BtnPlusRight = findViewById(R.id.button_plus_right);
        BtnMinusRight = findViewById(R.id.button_minus_right);
        BtnReset = findViewById(R.id.button_reset);
        BtnUndo = findViewById(R.id.button_undo);
        BtnSwitch = findViewById(R.id.button_switch);
        TxtScoreLeft = findViewById(R.id.textView_score_left);
        TxtScoreRight = findViewById(R.id.textView_score_right);
        TxtMatchLeft = findViewById(R.id.textView_match_left);
        TxtMatchRight = findViewById(R.id.textView_match_right);

        BtnPlusLeftClik();
        BtnMinusLeftClik();
        BtnPlusRightClik();
        BtnMinusRightClik();
        BtnResetClick();
        BtnUndoClick();
        BtnSwitchCLick();

    }

    private void BtnPlusLeftClik() {
        BtnPlusLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score.scoreLeft == match_score - 1) {
                    score.scoreLeft = 0;
                    score.scoreRight = 0;
                    score.matchLeft++;
                }
                else {
                    score.scoreLeft++;
                }
                TxtScoreLeft.setText(Integer.toString(score.scoreLeft));
                TxtMatchLeft.setText(Integer.toString(score.matchLeft));
            }
        });
    }

    private void BtnMinusLeftClik() {
        BtnMinusLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.scoreLeft--;
                TxtScoreLeft.setText(Integer.toString(score.scoreLeft));
            }
        });
    }

    private void BtnPlusRightClik() {
        BtnPlusRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score.scoreRight == match_score - 1) {
                    score.scoreRight = 0;
                    score.matchRight++;
                }
                else {
                    score.scoreRight++;
                }
                TxtScoreRight.setText(Integer.toString(score.scoreRight));
                TxtMatchRight.setText(Integer.toString(score.matchRight));
            }
        });
    }

    private void BtnMinusRightClik() {
        BtnMinusRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.scoreRight--;
                TxtScoreRight.setText(Integer.toString(score.scoreRight));
            }
        });
    }

    private void BtnResetClick() {
        BtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.scoreLeft = 0;
                score.scoreRight = 0;
                score.matchLeft = 0;
                score.matchRight = 0;
                TxtScoreLeft.setText(Integer.toString(score.scoreLeft));
                TxtScoreRight.setText(Integer.toString(score.scoreRight));
                TxtMatchLeft.setText(Integer.toString(score.matchLeft));
                TxtMatchRight.setText(Integer.toString(score.matchRight));
            }
        });
    }

    private void BtnUndoClick() {
        BtnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = preScore;
                score.scoreLeft = 30;
                score.scoreRight = 30;
                TxtScoreLeft.setText(Integer.toString(score.scoreLeft));
                TxtScoreRight.setText(Integer.toString(score.scoreRight));
            }
        });
    }

    private void BtnSwitchCLick() {
        BtnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tmp = score.scoreLeft;
                score.scoreLeft = score.scoreRight;
                score.scoreRight = tmp;
                tmp = score.matchLeft;
                score.matchLeft = score.matchRight;
                score.matchRight = tmp;
                TxtScoreLeft.setText(Integer.toString(score.scoreLeft));
                TxtScoreRight.setText(Integer.toString(score.scoreRight));
                TxtMatchLeft.setText(Integer.toString(score.matchLeft));
                TxtMatchRight.setText(Integer.toString(score.matchRight));
            }
        });
    }
}
