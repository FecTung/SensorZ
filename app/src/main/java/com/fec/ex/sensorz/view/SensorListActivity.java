package com.fec.ex.sensorz.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.fec.ex.sensorz.R;

public class SensorListActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUpToolbar();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = new SensorListFragment();
        ft.add(fragment, "SensorList");
        ft.replace(R.id.SensorListPlaceholder, fragment);
        ft.commit();
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);

    }
}
