package com.fec.ex.sensorz;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.SENSOR_SERVICE;

public class SensorListFragment extends Fragment {

    private ArrayList<SensorItem> mSensorItems;
    private SensorManager mSensorManager;
    private List<Sensor> mSensorList;

//    private static final String SENSOR_NAME = "name";
//    private static final String SENSOR_TYPE = "type";
//    private String mSensorName;
//    private String mSensorType;
//
//
//    public static SensorListFragment newInstance(String name, String type) {
//        SensorListFragment fragment = new SensorListFragment();
//        Bundle args = new Bundle();
//        args.putString(SENSOR_NAME, name);
//        args.putString(SENSOR_TYPE, type);
//        fragment.setArguments(args);
//        return fragment;
//    }

    public SensorListFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mSensorName = getArguments().getString(SENSOR_NAME);
//            mSensorType = getArguments().getString(SENSOR_TYPE);
//        }
//    }

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

        SensorRvAdapter adapter = new SensorRvAdapter(getActivity(), mSensorItems);
        adapter.setOnItemClickListener(new SensorRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Sensor sensor = mSensorList.get(position);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.SensorListPlaceholder, SensorFragment.newInstance(sensor.getName(), sensor.getType()))
                        .addToBackStack("SensorList")
                        .commit();
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private ArrayList<SensorItem> InitSensorItems(List<Sensor> sensorList) {
        ArrayList<SensorItem> sensorItems = new ArrayList<>();
        ArrayList<Integer> sensorIndex = new ArrayList<>();
        for (Sensor sensor : sensorList) {
            //Skip the repeated sensors by Sensor.getType()
            if (sensorIndex.contains(sensor.getType())) {
                continue;
            } else {
                sensorIndex.add(sensor.getType());
            }
            sensorItems.add(new SensorItem(sensor.getName(), sensor.getType()));
        }
        return sensorItems;
    }
}
