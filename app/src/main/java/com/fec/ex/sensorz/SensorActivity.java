package com.fec.ex.sensorz;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor mAccelerometer;          // TYPE_ACCELEROMETER
    private Sensor mAmbientTemperature;     // TYPE_AMBIENT_TEMPERATURE
    private Sensor mGravity;                // TYPE_GRAVITY
    private Sensor mGyroscope;              // TYPE_GYROSCOPE
    private Sensor mLight;                  // TYPE_LIGHT
    private Sensor mLinearAcceleration;     // TYPE_LINEAR_ACCELERATION
    private Sensor mMagneticField;          // TYPE_MAGNETIC_FIELD
    private Sensor mPressure;               // TYPE_PRESSURE
    private Sensor mProximity;              // TYPE_PROXIMITY
    private Sensor mHumidity;               // TYPE_RELATIVE_HUMIDITY
    private Sensor mRotationVector;         // TYPE_ROTATION_VECTOR

    private ArrayList<SensorItem> mSensorItems;

    private SensorManager mSensorManager;
    private List<Sensor> mSensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvSensors);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        mSensorItems = InitSensorItems(mSensorList);
        SensorRvAdapter adapter = new SensorRvAdapter(this, mSensorItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private ArrayList<SensorItem> InitSensorItems(List<Sensor> sensorList) {
        ArrayList<SensorItem> sensorItems = new ArrayList<>();
        for (Sensor sensor:sensorList) {
            sensorItems.add(new SensorItem(sensor.getName(), "X:\nY:\nZ:"));
        }
        return sensorItems;
    }


    @Override
    protected void onResume() {
        super.onResume();
        RegisterSensorsListener(mSensorList);
    }

    @Override
    protected void onPause() {
        super.onPause();
        UnRegisterSensorsListener(mSensorList);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void RegisterSensorsListener(List<Sensor> mSensorList) {
    }

    private void UnRegisterSensorsListener(List<Sensor> mSensorList) {
    }

}
