package com.example.timerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.util.Locale;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //秒数
    private static final long START_TIME = 10000;

    //view
    private TextView text;
    private Button button_start_pause;
    private Button button_reset;

    private CountDownTimer countDownTimer;

    //タイマー稼働フラグ
    private boolean timerRunning;

    private long timeLeftMills = START_TIME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //クリックイベントを取得したいボタン
        button_start_pause = findViewById(R.id.button_start_pause);
        button_reset = findViewById(R.id.button_reset);

        //OnClickListener インターフェースを実装する
        button_start_pause.setOnClickListener(new View.OnClickListener(){
                //クリック時に実行
                @Override
                public void onClick(View view){
                startTimer();
        }
        });

        //button_reset.setOnClickListener({});

    }

    //タイマーを開始する
    private void startTimer(){

    }
    //一時停止
    private void stopTimer(){

    }
    //リセット
    private void resetTimer(){

    }

    //時刻を表示する
    private void updateCountdownText(){

    }
}