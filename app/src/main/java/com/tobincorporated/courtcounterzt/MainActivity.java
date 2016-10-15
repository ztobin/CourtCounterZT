package com.tobincorporated.courtcounterzt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView infinityScoreView;
    private int infinityScore;
    private TextView poppleScoreView;
    private int poppleScore;
    private MediaPlayer bikeHorn;
    AlertDialog alertDialog;

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


        alertDialog = new AlertDialog.Builder(MainActivity.this).create();


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
        bikeHorn = MediaPlayer.create(this , R.raw.bikehorn);
        bikeHorn.start();
        infinityScoreView.setText("" + infinityScore);
        poppleScoreView.setText("" + poppleScore);
    }


    public void resetClick(View view){

        alertDialog.setTitle("Game Over!");
        if( infinityScore>poppleScore) { alertDialog.setMessage("Team Infinity Wins!");}
        if( infinityScore<poppleScore) { alertDialog.setMessage("Team Popples Wins!");}
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
