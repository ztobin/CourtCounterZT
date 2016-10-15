package com.tobincorporated.courtcounterzt;

import android.media.MediaPlayer;
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

    }

    public void infinityClick(View view){
        infinityScore++;
        bikeHorn = MediaPlayer.create(this , R.raw.bikehorn);
        bikeHorn.start();
        infinityScoreView.setText("" + infinityScore);
    }
    public void poppleClick(View view){
        poppleScore++;
        bikeHorn = MediaPlayer.create(this , R.raw.bikehorn);
        bikeHorn.start();
        poppleScoreView.setText("" + poppleScore);
    }

    public void resetClick(View view){
        poppleScore=0;
        infinityScore=0;
        infinityScoreView.setText("" + infinityScore);
        poppleScoreView.setText("" + poppleScore);

    }
}
