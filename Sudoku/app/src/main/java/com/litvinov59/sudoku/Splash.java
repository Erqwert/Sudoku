package com.litvinov59.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getText(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(R.color.icons));
        toolbar.setLogo(R.drawable.ic_action_name);

        Thread logoTimer = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(2000);
                    Intent i = new Intent(Splash.this, Sudoku.class);
                    startActivity(i);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    finish();
                }
            }
        };
        logoTimer.start();
    }
}