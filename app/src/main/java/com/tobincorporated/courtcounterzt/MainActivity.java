package com.tobincorporated.courtcounterzt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView infinityScoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infinityScoreView = (TextView)findViewById(R.id.infinityScoreView);

        infinityScoreView.setText("0");
    }

    public void infinityClick(View view){

        infinityScoreView.setText("1");
    }
}
