package com.fec.ex.sensorz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SensorFragment extends Fragment {

    private static final String SENSOR_NAME = "name";
    private static final String SENSOR_TYPE = "type";

    private String mSensorName;
    private int mSensorType;

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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sensor, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvSensorName = (TextView) view.findViewById(R.id.tvSFSensorName);
        TextView tvSensorType = (TextView) view.findViewById(R.id.tvSFSensorType);
        tvSensorName.setText(mSensorName);
        tvSensorType.setText(mSensorType + "");
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    getActivity().getSupportFragmentManager().popBackStack("SensorList", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                }
                return false;
            }
        });
    }
}
