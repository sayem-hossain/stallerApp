package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mlistlayout;
    private ImageView mlogo;
    private ImageView mlogoText;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlogo = (ImageView) findViewById(R.id.logoview);
        mlogoText = (ImageView) findViewById(R.id.logoNameView);
        mlistlayout = (RelativeLayout) findViewById(R.id.mainlayout);
        getSupportActionBar().hide();


        handler =  new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i =  new Intent(MainActivity.this,SharedActivity.class);
                Pair[] pairs =  new Pair[2];
                pairs[0] = new Pair<View,String>(mlogo,"imageTransition");
                pairs[1] = new Pair<View,String>(mlogoText,"LogoNameTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);


                startActivity(i,options.toBundle());
            }
        }, 4000);


//        mlistlayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i =  new Intent(MainActivity.this,SharedActivity.class);
//                Pair[] pairs =  new Pair[2];
//                pairs[0] = new Pair<View,String>(mlogo,"imageTransition");
//                pairs[1] = new Pair<View,String>(mlogoText,"LogoNameTransition");
//
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
//
//
//                startActivity(i,options.toBundle());
//            }
//        });

    }
}