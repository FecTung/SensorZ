package com.fec.ex.sensorz;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Sensor mAccelerometer;          // TYPE_ACCELEROMETER
    private Sensor mAmbientTemperature;     // TYPE_AMBIENT_TEMPERATURE
    private Sensor mGravity;                // TYPE_GRAVITY
    private Sensor mGyroscope;              // TYPE_GYROSCOPE
    private Sensor mLight;                  // TYPE_LIGHT
    private Sensor mLinearAcceleration;     // TYPE_LINEAR_ACCELERATION
    private Sensor mMagneticField;          // TYPE_MAGNETIC_FIELD
    private Sensor mOrientation;            // TYPE_ORIENTATION
    private Sensor mPressure;               // TYPE_PRESSURE
    private Sensor mProximity;              // TYPE_PROXIMITY
    private Sensor mHumidity;               // TYPE_RELATIVE_HUMIDITY
    private Sensor mRotationVector;         // TYPE_ROTATION_VECTOR
    private Sensor mTemperature;            // TYPE_TEMPERATURE

    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAccelerometer != null) {
            mSensorManager.registerListener(mAccelerometerListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAccelerometer != null) {
            mSensorManager.unregisterListener(mAccelerometerListener);
        }
    }


    private SensorEventListener mAccelerometerListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

}
