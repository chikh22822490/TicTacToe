package com.chikhaoui.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class PlayerSetup extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        player1 = findViewById(R.id.et_name_player1);
        player2 = findViewById(R.id.et_name_player2);
    }

    public void submitButtonClick(View view){
        String player1Name = "Player1";
        String player2Name = "Player2";

        if(player1.getText().length()!=0)
            player1Name = player1.getText().toString();

        if(player2.getText().length()!=0)
            player2Name = player2.getText().toString();


        Intent intent = new Intent(this, GameDisplay.class);
        intent.putExtra("player_names", new String[] {player1Name,player2Name});
        startActivity(intent);
    }
}