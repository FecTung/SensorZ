package com.fec.ex.sensorz.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fec.ex.sensorz.R;
import com.fec.ex.sensorz.model.SensorItem;
import com.fec.ex.sensorz.model.SensorRvAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.SENSOR_SERVICE;

public class SensorListFragment extends Fragment {

    private ArrayList<SensorItem> mSensorItems;
    private SensorManager mSensorManager;
    private List<Sensor> mSensorList;
    private SharedPreferences sharedPreferences;

    public SensorListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sensor_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvSensors);

        mSensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        mSensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        mSensorItems = InitSensorItems(mSensorList);
        sharedPreferences = android.support.v7.preference.PreferenceManager.getDefaultSharedPreferences(getContext());

        SensorRvAdapter adapter = new SensorRvAdapter(getActivity(), mSensorItems);
        adapter.setOnItemClickListener(new SensorRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                holdByActivity(position);
                holdByFragment(position);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Snackbar.make(view, "GET ALL SENSORS COMPLETED.", Snackbar.LENGTH_SHORT).setAction("I SEE", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }

    private void holdByFragment(int position) {
        Sensor sensor = mSensorList.get(position);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("SensorList")
                .replace(R.id.SensorListPlaceholder, SensorFragment.newInstance(sensor.getName(), sensor.getType()))
                .commit();
    }

    private void holdByActivity(int position) {
        Sensor sensor = mSensorList.get(position);
        Intent intent = new Intent(getContext(), SensorActivity.class);
        intent.putExtra("SensorName", sensor.getName());
        intent.putExtra("SensorType", sensor.getType());
        startActivity(intent);
    }

    private ArrayList<SensorItem> InitSensorItems(List<Sensor> sensorList) {
        ArrayList<SensorItem> sensorItems = new ArrayList<>();
        ArrayList<Integer> sensorIndex = new ArrayList<>();
        boolean showMore = false;
        if (sharedPreferences!=null) {
            showMore = sharedPreferences.getBoolean("pref_show_more", false);
        }
        for (Sensor sensor : sensorList) {
//            Skip the repeated sensors by Sensor.getType()
            if (!showMore && sensorIndex.contains(sensor.getType())) {
                continue;
            } else {
                sensorIndex.add(sensor.getType());
            }
            sensorItems.add(new SensorItem(sensor.getName(), sensor.getType()));
        }
        return sensorItems;
    }
}
