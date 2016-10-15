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
    private MediaPlayer bikeHorn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infinityScoreView = (TextView)findViewById(R.id.infinityScoreView);
        infinityScore =0;
        infinityScoreView.setText("0");
        bikeHorn = MediaPlayer.create(this , R.raw.bikehorn);

    }

    public void infinityClick(View view){
        infinityScore++;
        bikeHorn = MediaPlayer.create(this , R.raw.bikehorn);
        bikeHorn.start();
        infinityScoreView.setText("" + infinityScore);
    }
}
