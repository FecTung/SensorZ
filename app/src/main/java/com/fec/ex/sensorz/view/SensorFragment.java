package com.fec.ex.sensorz.view;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fec.ex.sensorz.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.SENSOR_SERVICE;

public class SensorFragment extends Fragment implements SensorEventListener {

    private static final String SENSOR_NAME = "name";
    private static final String SENSOR_TYPE = "type";

    private String VALUE_ACCELEROMETER = "VALUE_ACCELEROMETER";
    private String VALUE_AMBIENT_TEMPERATURE = "VALUE_AMBIENT_TEMPERATURE";
    private String VALUE_GRAVITY = "VALUE_GRAVITY";
    private String VALUE_GYROSCOPE = "VALUE_GYROSCOPE";
    private String VALUE_LIGHT = "VALUE_LIGHT";
    private String VALUE_LINEAR_ACCELERATION = "VALUE_LINEAR_ACCELERATION";
    private String VALUE_MAGNETIC_FIELD = "VALUE_MAGNETIC_FIELD";
    private String VALUE_PRESSURE = "VALUE_PRESSURE";
    private String VALUE_PROXIMITY = "VALUE_PROXIMITY";
    private String VALUE_RELATIVE_HUMIDITY = "VALUE_RELATIVE_HUMIDITY";
    private String VALUE_ROTATION_VECTOR = "VALUE_ROTATION_VECTOR";

    private String mSensorName;
    private int mSensorType;
    private boolean hasSensor = true;
    private SensorManager mSensorManager;

    private TextView tvSensorName;
    private TextView tvSensorType;
    private TextView tvSensorValue;

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

    private List<Sensor> mSensorList;

    public SensorFragment() {
    }

    public static SensorFragment newInstance(String name, int type) {
        SensorFragment fragment = new SensorFragment();
        Bundle args = new Bundle();
        args.putString(SENSOR_NAME, name);
        args.putInt(SENSOR_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSensorName = getArguments().getString(SENSOR_NAME);
            mSensorType = getArguments().getInt(SENSOR_TYPE);
        } else {
            hasSensor = false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sensor, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvSensorName = (TextView) view.findViewById(R.id.tvSFSensorName);
        tvSensorType = (TextView) view.findViewById(R.id.tvSFSensorType);
        tvSensorValue = (TextView) view.findViewById(R.id.tvSFSensorValue);
        tvSensorName.setText(mSensorName);
        tvSensorType.setText("Type: " + mSensorType);
        tvSensorValue.setText("VALUE");

        mSensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        mSensorList = new ArrayList<Sensor>();

        getSensorInstance();
        getValueSucceed(view);
    }

    private void setTVSensorValue(int mSensorType) {
        switch (mSensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                tvSensorValue.setText(VALUE_ACCELEROMETER);
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                tvSensorValue.setText(VALUE_AMBIENT_TEMPERATURE);
                break;
            case Sensor.TYPE_GRAVITY:
                tvSensorValue.setText(VALUE_GRAVITY);
                break;
            case Sensor.TYPE_GYROSCOPE:
                tvSensorValue.setText(VALUE_GYROSCOPE);
                break;
            case Sensor.TYPE_LIGHT:
                tvSensorValue.setText(VALUE_LIGHT);
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                tvSensorValue.setText(VALUE_LINEAR_ACCELERATION);
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                tvSensorValue.setText(VALUE_MAGNETIC_FIELD);
                break;
            case Sensor.TYPE_PRESSURE:
                tvSensorValue.setText(VALUE_PRESSURE);
                break;
            case Sensor.TYPE_PROXIMITY:
                tvSensorValue.setText(VALUE_PROXIMITY);
                break;
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                tvSensorValue.setText(VALUE_RELATIVE_HUMIDITY);
                break;
            case Sensor.TYPE_ROTATION_VECTOR:
                tvSensorValue.setText(VALUE_ROTATION_VECTOR);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        for (Sensor sensor : mSensorList) {
            sensorRegisterEvent(sensor, true);
        }

        handleBackEvent();
    }

    @Override
    public void onPause() {
        super.onPause();
        for (Sensor sensor : mSensorList) {
            sensorRegisterEvent(sensor, false);
        }
    }

    private void sensorRegisterEvent(Sensor sensor, boolean flag) {
        if (sensor != null) {
            if (flag) {
                mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
            } else {
                mSensorManager.unregisterListener(this);
            }
        }
    }

    private void getSensorInstance() {
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        addSensor(mAccelerometer);
        mAmbientTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        addSensor(mAmbientTemperature);
        mGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        addSensor(mGravity);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        addSensor(mGyroscope);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        addSensor(mLight);
        mLinearAcceleration = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        addSensor(mLinearAcceleration);
        mMagneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        addSensor(mMagneticField);
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        addSensor(mPressure);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        addSensor(mProximity);
        mHumidity = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        addSensor(mHumidity);
        mRotationVector = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        addSensor(mRotationVector);
    }

    private void addSensor(Sensor sensor) {
        if (sensor != null) {
            mSensorList.add(sensor);
        }
    }

    private void getValueSucceed(View view) {
        if (!hasSensor) {
            Snackbar.make(view, "Can't get the sensor's value.", Snackbar.LENGTH_SHORT).setAction("CANCEL", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            }).show();
        } else {
            Snackbar.make(view, "Get sensor's value succeed!", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            }).show();
        }
    }

    private void handleBackEvent() {
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    getActivity().getSupportFragmentManager().popBackStack("SensorList", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                VALUE_ACCELEROMETER = "X:" + event.values[0] + "\nY:" + event.values[1] + "\nZ:" + event.values[2];
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                VALUE_AMBIENT_TEMPERATURE = "Celsius:" + event.values[0];
            case Sensor.TYPE_GRAVITY:
                VALUE_GRAVITY = "X:" + event.values[0] + "\nY:" + event.values[1] + "\nZ:" + event.values[2];
            case Sensor.TYPE_GYROSCOPE:
                VALUE_GYROSCOPE = "X:" + event.values[0] + "\nY:" + event.values[1] + "\nZ:" + event.values[2];
            case Sensor.TYPE_LIGHT:
                VALUE_LIGHT = "lux:" + event.values[0];
            case Sensor.TYPE_LINEAR_ACCELERATION:
                VALUE_LINEAR_ACCELERATION = "X:" + event.values[0] + "\nY:" + event.values[1] + "\nZ:" + event.values[2];
            case Sensor.TYPE_MAGNETIC_FIELD:
                VALUE_MAGNETIC_FIELD = "X:" + event.values[0] + "\nY:" + event.values[1] + "\nZ:" + event.values[2];
            case Sensor.TYPE_PRESSURE:
                VALUE_PRESSURE = "hPa:" + event.values[0];
            case Sensor.TYPE_PROXIMITY:
                VALUE_PROXIMITY = "Centimeters:" + event.values[0];
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                VALUE_RELATIVE_HUMIDITY = "percent:" + event.values[0];
            case Sensor.TYPE_ROTATION_VECTOR:
                VALUE_ROTATION_VECTOR = "x*sin(θ/2):" + event.values[0] + "\ny*sin(θ/2):" + event.values[1] + "\nz*sin(θ/2):" + event.values[2];
        }
        setTVSensorValue(mSensorType);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
