package com.example.mpa1;
//<uses-permission android:name="android.permission.INTERNET"/> in AndroidManifest.xml

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String url;
    EditText editText;
    private Button btn_load;
    private Button btn_move;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et_url);
        btn_load = findViewById(R.id.btn_load);
        btn_move = findViewById(R.id.btn_move);



        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent receiveIntent = getIntent();

                url = receiveIntent.getStringExtra("url");
                editText.setText(url);
            }
        });

        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }
}
