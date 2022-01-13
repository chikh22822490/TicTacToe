package com.chikhaoui.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBtn = findViewById(R.id.btn_replay);
        Button homeBtn = findViewById(R.id.btn_home);
        TextView playerDisplay = findViewById(R.id.txt_playeDisplay);

        String[] playerNames = getIntent().getStringArrayExtra("player_names");

        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setUpGame(playAgainBtn, homeBtn, playerDisplay, playerNames);
        if(playerNames != null){
            playerDisplay.setText((playerNames[0] + "'s Turn"));
        }
    }

    public void replayButtonClick(View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}