package com.example.clientsockettest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Handler client = new Handler(); // client가 handler인건가? 불확실
    Handler mServiceHandler = new Handler();
    Message msg = new Message();
    EditText text;

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(client != null) { //소켓과 스레드를 모두 종료시킨다.
            msg = mServiceHandler.obtainMessage(); // Message객체 생성
            msg.what = MSG_STOP;
            mServiceHandler.sendMessage(msg);
        }
        thread.quit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 변수 초기화 및 UI설정
        Looper mServiceLooper = new Looper();
        text = findViewById(R.id.et_msg);



        HandlerThread thread = new HandlerThread("HandlerThread");
        thread.start();
        //루퍼를 만든다.
        mServiceLooper = thread.getLooper();
        mServiceHandler = new Handler(mServiceLooper);

        Handler mMainHandler = new Handler();

            public void handleMessage(Message msg){
            String m;
            switch (msg.what) {
                case MSG_CONNECT:
                    m = "정상적으로 서버에 접속";
                    text.setText(m); // text가 editText ?
                    break;

                case MSG_CLIENT_STOP:
                    text.setText((String) msg.obj);
                    m = "클라이언트가 접속을 종료하였습니다.";
                    break;

                case MSG_SERVER_STOP:
                    text.setText((String) msg.obj);
                    m = "서버가 접속을 종료하였습니다.";
                    break;

                case MSG_START:
                    m = "메세지 전송 완료!";
                    text.setText((String) msg.obj);
                    break;

                default:
                    m = "에러 발생";
                    text.setText((String) msg.obj);
                    break;
            }

            Toast.makeText(TcpClientActivity.this, m, Toast.LENGTH_SHORT).show();
            super.handleMessage(msg);
        }


}
