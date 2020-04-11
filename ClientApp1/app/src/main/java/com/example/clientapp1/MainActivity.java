package com.example.clientapp1;
//<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" /> in AndroidManifest.xml
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_addr;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_1v2;
    private Button btn_4;
    private Button btn_5;
    private Button btn_orbot;

    String url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_addr = findViewById(R.id.et_addr);

        btn_1 = findViewById(R.id.btn_1); // 바로이동
        btn_2 = findViewById(R.id.btn_2); // proxy경유
        btn_3 = findViewById(R.id.btn_3); // MPA3 경유
        btn_1v2 = findViewById(R.id.btn_1v2); // 바로이동2
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);

        btn_orbot = findViewById(R.id.btn_orbot);

        /*
        orbot 실행 버튼
         */
        btn_orbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ComponentName compName = new ComponentName("org.torproject.android",
                        "org.torproject.android.OrbotMainActivity");

                Intent intent = new Intent (Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setComponent(compName);
                startActivity(intent);

            }
        });
        /*
        이동:바로
         */
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                url = et_addr.getText().toString();

                /*
                intent 사용해서 url 전달 코드

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, url);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                */

                ComponentName compMPA1 = new ComponentName("com.example.mpa1",
                        "com.example.mpa1.MainActivity");

                Intent intent = new Intent (Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                //intent.setAction(Intent.ACTION_SEND);
                intent.putExtra("url",url);
                //intent.setType("text/plain");
                intent.setComponent(compMPA1);
                startActivity(intent);


            }
        });


        /*
        이동:토르
         */
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                url = et_addr.getText().toString();

                /*
                intent 사용해서 url 전달 코드

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, url);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                 */

                ComponentName compMPA2 = new ComponentName("com.example.mpa2",
                        "com.example.mpa2.MainActivity");

                Intent intent = new Intent (Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                //intent.setAction(Intent.ACTION_SEND);
                intent.putExtra("url", url);
                //intent.setType("text/plain");
                intent.setComponent(compMPA2);
                startActivity(intent);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                url = et_addr.getText().toString();
                ComponentName compMPA3 = new ComponentName("com.example.mpa3",
                        "com.example.mpa3.MainActivity");

                Intent intent = new Intent (Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                //intent.setAction(Intent.ACTION_SEND);
                intent.putExtra("url", url);
                //intent.setType("text/plain");
                intent.setComponent(compMPA3);
                startActivity(intent);
            }
        });

        btn_1v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                url = et_addr.getText().toString();
                ComponentName compMPA1v2 = new ComponentName("com.example.mpa1v2",
                        "com.example.mpa1v2.MainActivity");

                Intent intent = new Intent (Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                //intent.setAction(Intent.ACTION_SEND);
                intent.putExtra("url", url);
                //intent.setType("text/plain");
                intent.setComponent(compMPA1v2);
                startActivity(intent);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                url = et_addr.getText().toString();
                ComponentName compMPA4 = new ComponentName("com.example.mpa4",
                        "com.example.mpa4.MainActivity");

                Intent intent = new Intent (Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                //intent.setAction(Intent.ACTION_SEND);
                intent.putExtra("url", url);
                //intent.setType("text/plain");
                intent.setComponent(compMPA4);
                startActivity(intent);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                url = et_addr.getText().toString();
                ComponentName compMPA5 = new ComponentName("com.example.mpa5",
                        "com.example.mpa5.MainActivity");

                Intent intent = new Intent (Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                //intent.setAction(Intent.ACTION_SEND);
                intent.putExtra("url", url);
                //intent.setType("text/plain");
                intent.setComponent(compMPA5);
                startActivity(intent);
            }
        });

    }
}
