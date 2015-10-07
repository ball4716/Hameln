package com.isoft.ible;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //ImageView imgMain;
        //imgMain = new ImageView(this);
        //imgMain.setBackground(R.drawable.);
        //setContentView(imgMain);

        setTimer();
    }
    private void setTimer() {
        MoveActivityTask moveTask = new MoveActivityTask();

        // 1초 후 MoveActivityTask 실행
        Timer timerStart = new Timer(false);
        timerStart.schedule(moveTask, 1000);
    }

    class MoveActivityTask extends TimerTask {
        @Override
        public void run() {
            //내부저장소에 저장된 정보 불러옴
            //SharedPreferences pref = getSharedPreferences(GlobalArgs.PREF_NAME, 0);
            //int checkValue = pref.getInt(GlobalArgs.User.FontSize.toString(), 0);

            Intent i;
            //if(checkValue == 0)//최초실행일 때
                i = new Intent(SplashActivity.this, BirthActivity.class);
            //else//아닐 때
            //    i = new Intent(SplashActivity.this, MainActivity.class);

            startActivity(i);
            finish();
        }
    }
}
