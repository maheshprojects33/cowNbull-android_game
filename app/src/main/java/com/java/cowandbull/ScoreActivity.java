package com.java.cowandbull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class ScoreActivity extends AppCompatActivity  {

    private TextView totalGameScore, totalWinScore;

    public String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        initViews();

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("totalGamePlayed", Context.MODE_PRIVATE);
        int gamePlay = sharedPreferences.getInt("gamePlayed", MODE_PRIVATE);
        //String gameWin = sharedPreferences.getString("gameWin", "DEFAULT");


            totalGameScore.setText(String.valueOf(gamePlay));
           // totalWinScore.setText(gameWin);
            Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();












    }

    private void initViews() {
        totalGameScore = findViewById(R.id.tvTotalGameScore);
        totalWinScore = findViewById(R.id.tvTotalWinScore);
    }
}