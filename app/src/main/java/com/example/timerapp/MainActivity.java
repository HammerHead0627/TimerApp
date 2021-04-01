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

    //最初の設定値をミリ秒単位で定義
    private static final long START_TIME = 10000;

    //view
    private TextView timerText;
    private Button button_start_pause;
    private Button button_reset;

    private CountDownTimer countDownTimer;

    //タイマー稼働フラグ
    private boolean timerRunning;

    //タイマーの初期値
    private long timeLeftMills = START_TIME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //表示時間
        timerText = findViewById(R.id.text_view_countdown);

        //クリックイベントを取得したいボタン
        button_start_pause = findViewById(R.id.button_start_pause);
        button_reset = findViewById(R.id.button_reset);

        //OnClickListener インターフェースを実装する
        button_start_pause.setOnClickListener(new View.OnClickListener() {
            //クリック時に実行
            @Override
            public void onClick(View view) {
                //タイマーが稼働している場合、一時停止する
                if (timerRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }
        });

        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountdownText();
    }

    //タイマーを開始する
    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftMills, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftMills = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                button_start_pause.setText("スタート");
                button_reset.setVisibility(View.INVISIBLE);
            }
        }.start();

        timerRunning = true;
        button_start_pause.setText("一時停止");
        button_reset.setVisibility(View.INVISIBLE);
    }

    //一時停止
    private void stopTimer() {

        countDownTimer.cancel();
        timerRunning = false;
        button_start_pause.setText("スタート");
        button_reset.setVisibility(View.VISIBLE);
    }

    //リセット
    private void resetTimer() {
        //タイマーの設定値を初期値に戻す
        timeLeftMills = START_TIME;
        updateCountdownText();

        //ボタンの表示を切り変える
        button_start_pause.setVisibility(View.VISIBLE);
        button_reset.setVisibility(View.INVISIBLE);

    }

    //時刻を表示する
    private void updateCountdownText() {
        //初期値を秒にし、60で割って分とする
        int minutes = (int) ((timeLeftMills) / 1000) / 60;
        //初期値を秒にし、60で割って剰余を秒とする
        int seconds = (int) ((timeLeftMills) / 1000) % 60;

        //フォーマットを整える
        String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        //テキスト部に表示する
        timerText.setText(timerLeftFormatted);
    }
}