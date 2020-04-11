package com.example.httpurlconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView tv;
    EditText et1, et2;

    String userid = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv = findViewById(R.id.tv);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

    }

    public void onClick3(View v) {
        userid = et1.getText().toString();
        password = et2.getText().toString();
        if(userid.equals("")|| password.equals("")) {

        }
    }
}
