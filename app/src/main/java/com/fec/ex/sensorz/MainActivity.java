package com.fec.ex.sensorz;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

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

    private TextView tvAccelerometer;
    private TextView tvAmbientTemperature;
    private TextView tvGravity;
    private TextView tvGyroscope;
    private TextView tvLight;
    private TextView tvLinearAcceleration;
    private TextView tvMagneticField;
    private TextView tvPressure;
    private TextView tvProximity;
    private TextView tvHumidity;
    private TextView tvRotationVector;

    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mAmbientTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mLinearAcceleration = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        mMagneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mHumidity = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        mRotationVector = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        tvAccelerometer = (TextView) findViewById(R.id.tvAccelerometer);
        tvAmbientTemperature = (TextView) findViewById(R.id.tvAmbientTemperature);
        tvGravity = (TextView) findViewById(R.id.tvGravity);
        tvGyroscope = (TextView) findViewById(R.id.tvGyroscope);
        tvLight = (TextView) findViewById(R.id.tvLight);
        tvLinearAcceleration = (TextView) findViewById(R.id.tvLinearAcceleration);
        tvMagneticField = (TextView) findViewById(R.id.tvMagneticField);
        tvPressure = (TextView) findViewById(R.id.tvPressure);
        tvProximity = (TextView) findViewById(R.id.tvProximity);
        tvHumidity = (TextView) findViewById(R.id.tvHumidity);
        tvRotationVector = (TextView) findViewById(R.id.tvRotationVector);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAccelerometer != null) {
            mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mAmbientTemperature != null){
            mSensorManager.registerListener(this, mAmbientTemperature, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mGravity != null){
            mSensorManager.registerListener(this, mGravity, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mGyroscope != null){
            mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mLight != null){
            mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mLinearAcceleration != null){
            mSensorManager.registerListener(this, mLinearAcceleration, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mMagneticField != null){
            mSensorManager.registerListener(this, mMagneticField, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mPressure != null){
            mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mProximity != null){
            mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mHumidity != null){
            mSensorManager.registerListener(this, mHumidity, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mRotationVector != null){
            mSensorManager.registerListener(this, mRotationVector, SensorManager.SENSOR_DELAY_NORMAL);
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAccelerometer != null) {
            mSensorManager.unregisterListener(this);
        }
        if (mAmbientTemperature != null) {
            mSensorManager.unregisterListener(this);
        }
        if (mGravity != null) {
            mSensorManager.unregisterListener(this);
        }
        if (mGyroscope != null) {
            mSensorManager.unregisterListener(this);
        }
        if (mLight != null) {
            mSensorManager.unregisterListener(this);
        }
        if (mLinearAcceleration != null) {
            mSensorManager.unregisterListener(this);
        }
        if (mMagneticField != null) {
            mSensorManager.unregisterListener(this);
        }
        if (mPressure != null) {
            mSensorManager.unregisterListener(this);
        }
        if (mProximity != null) {
            mSensorManager.unregisterListener(this);
        }
        if (mHumidity != null) {
            mSensorManager.unregisterListener(this);
        }
        if (mRotationVector != null) {
            mSensorManager.unregisterListener(this);
        }
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                tvAccelerometer.setText("X:"+event.values[0]+"\nY:"+event.values[1]+"\nZ:"+event.values[2]);
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                tvAmbientTemperature.setText("Celsius:"+event.values[0]);
            case Sensor.TYPE_GRAVITY:
                tvGravity.setText("X:"+event.values[0]+"\nY:"+event.values[1]+"\nZ:"+event.values[2]);
            case Sensor.TYPE_GYROSCOPE:
                tvGyroscope.setText("X:"+event.values[0]+"\nY:"+event.values[1]+"\nZ:"+event.values[2]);
            case Sensor.TYPE_LIGHT:
                tvLight.setText("lux:"+event.values[0]);
            case Sensor.TYPE_LINEAR_ACCELERATION:
                tvLinearAcceleration.setText("X:"+event.values[0]+"\nY:"+event.values[1]+"\nZ:"+event.values[2]);
            case Sensor.TYPE_MAGNETIC_FIELD:
                tvMagneticField.setText("X:"+event.values[0]+"\nY:"+event.values[1]+"\nZ:"+event.values[2]);
            case Sensor.TYPE_PRESSURE:
                tvPressure.setText("hPa:"+event.values[0]);
            case Sensor.TYPE_PROXIMITY:
                tvProximity.setText("Centimeters:"+event.values[0]);
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                tvHumidity.setText("percent:"+event.values[0]);
            case Sensor.TYPE_ROTATION_VECTOR:
                tvRotationVector.setText("x*sin(θ/2):"+event.values[0]+"\ny*sin(θ/2):"+event.values[1]+"\nz*sin(θ/2):"+event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
