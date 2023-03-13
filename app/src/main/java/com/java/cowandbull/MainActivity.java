package com.java.cowandbull;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay, btnRules, btnExit, btnScore;

    private TextView tvMahesh;

    MediaPlayer backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        backgroundMusic();


        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScoreActivity.class));
            }
        });



        tvMahesh.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvMahesh.setText("This is To Let You Feel Special My Dear");
                return false;
            }
        });




    }



    private void initViews() {
        btnPlay = findViewById(R.id.btnPlay);
        btnRules = findViewById(R.id.btnRules);
        btnExit = findViewById(R.id.btnExit);
        btnScore = findViewById(R.id.btnScore);

        tvMahesh = findViewById(R.id.tvMahesh);
    }

    private void backgroundMusic(){
        backgroundMusic = MediaPlayer.create(this, R.raw.game_music);
        backgroundMusic.setLooping(true);
        backgroundMusic.start();
    }

    public void playBtn(View view) {
        startActivity(new Intent(this, GameActivity.class));
        backgroundMusic.stop();
    }

    public void rulesBtn(View view) {
        startActivity(new Intent(this, Rules.class));
    }

    public void exitBtn(View view) {
        moveTaskToBack(true);
        backgroundMusic.stop();
        finish();

    }
}