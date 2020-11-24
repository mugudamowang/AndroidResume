package com.example.teamresume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class StartPageActivity extends Activity {

    private ImageView logoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        //Remove title bar
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //Remove notification bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        //set content view AFTER ABOVE sequence (to avoid crash)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        //启动页动画
        logoView = (ImageView)findViewById(R.id.img_logo);
        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in_cu);
        logoView.startAnimation(aniFade);

        int timeout = 1800; // make the activity visible for 4 seconds
        //set timeout and redirect to MainActivity
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent homepage = new Intent(StartPageActivity.this, MainActivity.class);
                startActivity(homepage);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);//在finish之前, 可能由于定时器和anim的时间冲突导致
                finish();
            }
        }, timeout);
    }
}