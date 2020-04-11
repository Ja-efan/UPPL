package com.example.subwaymain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button savebtn,exit1,exit2,exit3;
    EditText url1;
    public String saveUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        savebtn = (Button)findViewById(R.id.savebtn);
        exit1 = (Button)findViewById(R.id.exit1);
        exit2 = (Button)findViewById(R.id.exit2);
        exit3 = (Button)findViewById(R.id.exit3);
        url1 = (EditText)findViewById(R.id.url1);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUrl = url1.getText().toString();
                String msg = saveUrl + " 로 지정되었습니다.";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });
        exit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(saveUrl.equals("")){
                    Toast.makeText(getApplicationContext(),"지정된 주소가 없습니다.",Toast.LENGTH_SHORT).show();
                }
                else {
                    ComponentName nameExit1 = new ComponentName("com.example.subwayexit1",
                            "com.example.subwayexit1.MainActivity");
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.setComponent(nameExit1);
                    intent.putExtra("url",saveUrl);
                    startActivity(intent);
                }
            }
        });
        exit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(saveUrl.equals("")){
                    Toast.makeText(getApplicationContext(),"지정된 주소가 없습니다.",Toast.LENGTH_SHORT).show();
                }
                else {
                    ComponentName nameExit1 = new ComponentName("com.example.subwayexit2",
                            "com.example.subwayexit2.MainActivity");
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.setComponent(nameExit1);
                    intent.putExtra("url",saveUrl);
                    startActivity(intent);
                }
            }
        });
        exit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(saveUrl.equals("")){
                    Toast.makeText(getApplicationContext(),"지정된 주소가 없습니다.",Toast.LENGTH_SHORT).show();
                }
                else {
                    ComponentName nameExit1 = new ComponentName("com.example.subwayexit3",
                            "com.example.subwayexit3.MainActivity");
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.setComponent(nameExit1);
                    intent.putExtra("url",saveUrl);
                    startActivity(intent);
                }
            }
        });
    }
}
