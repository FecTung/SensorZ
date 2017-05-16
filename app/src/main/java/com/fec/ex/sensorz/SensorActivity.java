package com.fec.ex.sensorz;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SensorActivity extends AppCompatActivity {

    private ArrayList<SensorItem> mSensors;

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private List<Sensor> mSensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvSensors);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        mSensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);

    }
}
