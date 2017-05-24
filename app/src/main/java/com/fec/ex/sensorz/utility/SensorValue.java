package com.fec.ex.sensorz.utility;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorValue {

    private static final SensorValue singleInstance = new SensorValue();

    public static SensorValue getInstance() {
        return singleInstance;
    }

    private SensorValue() {
    }

}
