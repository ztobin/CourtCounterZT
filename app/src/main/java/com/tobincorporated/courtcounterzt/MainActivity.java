package com.tobincorporated.courtcounterzt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView infinityScoreView;
    private int infinityScore;
    private TextView poppleScoreView;
    private int poppleScore;
    private MediaPlayer bikeHorn;
    AlertDialog alertDialog;
    private EditText team1View;
    private EditText team2View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infinityScoreView = (TextView)findViewById(R.id.infinityScoreView);
        infinityScore =0;
        infinityScoreView.setText("0");

        poppleScoreView = (TextView)findViewById(R.id.poppleScoreView);
        poppleScore =0;
        poppleScoreView.setText("0");
        bikeHorn = MediaPlayer.create(this , R.raw.bikehorn);
        team1View = (EditText) findViewById(R.id.team1View);
        team2View = (EditText) findViewById(R.id.team2View);
//
//        team1View.setImeOptions(EditorInfo.IME_ACTION_DONE);
//        team2View.setImeOptions(EditorInfo.IME_ACTION_DONE);

        alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        bikeHorn = MediaPlayer.create(this , R.raw.bikehorn);

    }

    public void infinityClickMinus(View view){
        infinityScore--;
        scoreUpdate();
    }
    public void poppleClickMinus(View view){
        poppleScore--;
        scoreUpdate();
    }
    public void infinityClick(View view){
        infinityScore++;
        scoreUpdate();
    }
    public void poppleClick(View view){
        poppleScore++;
        scoreUpdate();
    }

    private void scoreUpdate(){
        bikeHorn.seekTo(0);
        bikeHorn.start();
        infinityScoreView.setText("" + infinityScore);
        poppleScoreView.setText("" + poppleScore);
    }


    public void resetClick(View view){

        alertDialog.setTitle("Game Over!");
        String team1Name = team1View.getText().toString();
        String team2Name = team2View.getText().toString();
        if( infinityScore>poppleScore) { alertDialog.setMessage(team1Name + " Wins!");}
        if( infinityScore<poppleScore) { alertDialog.setMessage(team2Name + " Wins!");}
        if( infinityScore==poppleScore) { alertDialog.setMessage("It's a Tie!");}
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

        poppleScore=0;
        infinityScore=0;
        infinityScoreView.setText("" + infinityScore);
        poppleScoreView.setText("" + poppleScore);


    }



}
