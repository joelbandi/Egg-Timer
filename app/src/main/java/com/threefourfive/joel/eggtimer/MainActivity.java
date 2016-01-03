package com.threefourfive.joel.eggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textview;
    SeekBar seekbar;


    public void updatetimer(int progress){

        int minutes = progress/60;
        int seconds = progress%60;
        String mins = Integer.toString(minutes);
        String secs =Integer.toString(seconds);
        if(seconds <= 9){
            secs = "0" + secs;
        }
        textview.setText(mins+" : "+secs);

    }


    public void go(){
        

        new CountDownTimer(seekbar.getProgress()*1000 + 100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updatetimer((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView)findViewById(R.id.text);
        button = (Button)findViewById(R.id.button);
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updatetimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
