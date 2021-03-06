package com.example.shourov.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class splash_screen extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //full screen activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.progressbarid);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                dowork();
                startmainactivity();

            }
        });
        thread.start();

    }
    public void dowork(){

        //progressbar timer set
        for (int progress = 20; progress <= 100 ; progress = progress + 20) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //go to main activity
    public void startmainactivity(){

        Intent intent = new Intent(splash_screen.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}
