package com.chikhaoui.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button playBtn;
    ProgressBar progressBar;
    TextView load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playBtn = findViewById(R.id.playBtn);
        playBtn.setVisibility(View.GONE);
        progressBar = findViewById(R.id.progressBar);
        load = findViewById(R.id.loading);
        new CountDownTimer(5000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(((5000-(int)millisUntilFinished)/1000)*20);
            }

            @Override
            public void onFinish() {
                progressBar.setVisibility(View.GONE);
                load.setVisibility(View.GONE);
                playBtn.setVisibility(View.VISIBLE);
            }
        }.start();

    }

    public void playButtonClick(View view){
        Intent intent = new Intent(this, PlayerSetup.class);
        startActivity(intent);
    }


}