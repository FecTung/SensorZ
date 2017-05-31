package com.fec.ex.sensorz.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.fec.ex.sensorz.R;

public class SensorActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private String mSensorName;
    private int mSensorType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUpToolbar();

        mSensorName = getIntent().getStringExtra("SensorName");
        mSensorType = getIntent().getIntExtra("SensorType", -1);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment;
        if (mSensorName != null && mSensorType != -1) {
            fragment = SensorFragment.newInstance(mSensorName, mSensorType);
        } else {
            fragment = new SensorFragment();
        }
        ft.add(fragment, "Sensor");
        ft.replace(R.id.SensorPlaceholder, fragment);
        ft.commit();
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);

    }

}
