package com.example.sensortest02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor sensor;

    ConstraintLayout clMain;
    TextView textviewMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        clMain = (ConstraintLayout) findViewById(R.id.cl_main);
        textviewMessage = (TextView) findViewById(R.id.tv_message);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lightLux = sensorEvent.values[0];
            lightLux = (float) (Math.round(lightLux*100)/100.0);
            int color = (int) lightLux;
            clMain.setBackgroundColor(Color.rgb(color*2, color, color));
            textviewMessage.setText(String.valueOf(lightLux)+"lux");

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i){

    }
}
