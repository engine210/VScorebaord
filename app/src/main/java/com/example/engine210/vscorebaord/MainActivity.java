package com.example.engine210.vscorebaord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreLeft, scoreRight;
    private Button BtnPlusLeft;
    private Button BtnMinusLeft;
    private Button BtnPlusRight;
    private Button BtnMinusRight;
    private TextView TxtScoreLeft;
    private TextView TxtScoreRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnPlusLeft = findViewById(R.id.button_plus_left);
        BtnMinusLeft = findViewById(R.id.button_minus_left);
        BtnPlusRight = findViewById(R.id.button_plus_right);
        BtnMinusRight = findViewById(R.id.button_minus_right);
        TxtScoreLeft = findViewById(R.id.textView_score_left);
        TxtScoreRight = findViewById(R.id.textView_score_right);

        BtnPlusLeftClik();
        BtnMinusLeftClik();
        BtnPlusRightClik();
        BtnMinusRightClik();

    }

    private void BtnPlusLeftClik() {
        BtnPlusLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreLeft++;
                TxtScoreLeft.setText(Integer.toString(scoreLeft));
            }
        });
    }

    private void BtnMinusLeftClik() {
        BtnMinusLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreLeft--;
                TxtScoreLeft.setText(Integer.toString(scoreLeft));
            }
        });
    }

    private void BtnPlusRightClik() {
        BtnPlusRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreRight++;
                TxtScoreRight.setText(Integer.toString(scoreRight));
            }
        });
    }

    private void BtnMinusRightClik() {
        BtnMinusRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreRight--;
                TxtScoreRight.setText(Integer.toString(scoreRight));
            }
        });
    }
}
